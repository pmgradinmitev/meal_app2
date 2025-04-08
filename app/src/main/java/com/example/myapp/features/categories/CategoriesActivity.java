package com.example.myapp.features.categories;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapp.R;
import com.example.myapp.models.Category;
import com.example.myapp.endpoints.response.CategoriesResponse;
import com.example.myapp.endpoints.MealApi;
import com.example.myapp.features.categories.adapter.CategoriesAdapter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * CategoriesActivity is responsible for displaying a list of meal categories.
 *
 * This activity:
 * - Fetches categories from the Meal API.
 * - Displays them using a RecyclerView.
 * - Uses a CategoriesAdapter to bind data.
 */
public class CategoriesActivity extends AppCompatActivity {

    // Adapter for the RecyclerView
    private CategoriesAdapter adapter;

    /**
     * Called when the activity is first created.
     * Sets up the UI and initializes category fetching.
     *
     * @param savedInstanceState Previously saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories); // Set the layout for this activity

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Use LinearLayout for vertical scrolling

        // Set up the adapter
        adapter = new CategoriesAdapter();
        recyclerView.setAdapter(adapter);

        // Fetch categories from the API
        fetchCategories();
        fetchMealByMainIngrediant();
    }

    /**
     * Fetches the list of meal categories from the Meal API.
     * Uses Retrofit for network calls.
     */
    private void fetchCategories() {
        // Initialize Retrofit for network request
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/") // Base URL for API
                .addConverterFactory(GsonConverterFactory.create()) // Converts JSON response into Java objects
                .build();

        // Create API instance
        MealApi mealApi = retrofit.create(MealApi.class);

        // Make an asynchronous API call to fetch categories
        mealApi.getCategories().enqueue(new Callback<CategoriesResponse>() {
            /**
             * Called when the API call is successful.
             * Updates the RecyclerView with the received categories.
             */
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Category> categories = response.body().getCategories();
                    adapter.setCategories(categories); // Update adapter with new data
                }
            }

            /**
             * Called when the API call fails.
             * Displays a Toast message indicating the error.
             */
            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void fetchMealByMainIngrediant(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/") // Base URL for API
                .addConverterFactory(GsonConverterFactory.create()) // Converts JSON response into Java objects
                .build();

        MealApi mealApi = retrofit.create(MealApi.class);

        mealApi.getCategories().enqueue(new Callback<CategoriesResponse>() {
            /**
             * Called when the API call is successful.
             * Updates the RecyclerView with the received categories.
             */
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Category> categories = response.body().getCategories();
                    adapter.setCategories(categories); // Update adapter with new data
                }
            }

            /**
             * Called when the API call fails.
             * Displays a Toast message indicating the error.
             */
            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
