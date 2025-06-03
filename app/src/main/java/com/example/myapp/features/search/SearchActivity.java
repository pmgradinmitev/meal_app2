package com.example.myapp.features.search;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.endpoints.MealApi;
import com.example.myapp.endpoints.response.SearchResponse;
import com.example.myapp.features.search.adapter.SearchAdapter;
import com.example.myapp.models.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * SearchActivity is responsible for displaying the meal searched by the user.
 *
 * This activity:
 * - Fetches meals from the Meal API.
 * - Displays them using a RecyclerView.
 * - Uses a SearchAdapter to bind data.
 */
public class SearchActivity extends AppCompatActivity {
    // Adapter for the RecyclerView
    private SearchAdapter adapter;

    /**
     * Called when the activity is first created.
     * Sets up the UI and initializes meal fetching.
     *
     * @param savedInstanceState Previously saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search); // Set the layout for this activity

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Use LinearLayout for vertical scrolling

        // Set up the adapter
        adapter = new SearchAdapter();
        recyclerView.setAdapter(adapter);

        // Fetch meal from the API
        fetchMeal();
    }

    /**
     * Fetches the meal from the Meal API.
     * Uses Retrofit for network calls.
     */
    private void fetchMeal() {
        // Initialize Retrofit for network request
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/") // Base URL for API
                .addConverterFactory(GsonConverterFactory.create()) // Converts JSON response into Java objects
                .build();

        // Create API instance
        MealApi mealApi = retrofit.create(MealApi.class);

        // Make an asynchronous API call to fetch meal
        mealApi.getMealByName("chocolate").enqueue(new Callback<SearchResponse>() {
            /**
             * Called when the API call is successful.
             * Updates the RecyclerView with the received categories.
             */
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Meal> meals = response.body().getMeals();
                    adapter.setMeals(meals); // Update adapter with new data
                }
            }

            /**
             * Called when the API call fails.
             * Displays a Toast message indicating the error.
             */
            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
