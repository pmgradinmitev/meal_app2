package com.example.myapp.features.search.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.R;
import com.example.myapp.features.categories.adapter.CategoriesAdapter;
import com.example.myapp.models.Category;
import com.example.myapp.models.Meal;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MealViewHolder> {
    // List of categories to display
    private List<Meal> meals = new ArrayList<>();

    /**
     * Updates the category list and refreshes the RecyclerView.
     *
     * @param meals List of categories retrieved from the API.
     */
    public void setMeals(List<Meal> meals) {
        this.meals = meals != null ? meals : new ArrayList<>();
        notifyDataSetChanged(); // Notifies RecyclerView to rebind data
    }

    /**
     * Called when RecyclerView needs a new ViewHolder for an item.
     *
     * @param parent   The ViewGroup where the new View will be added.
     * @param viewType The type of the new View.
     * @return A new instance of CategoryViewHolder.
     */
    @NonNull
    @Override
    public SearchAdapter.MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a single category item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new SearchAdapter.MealViewHolder(view);
    }

    /**
     * Binds data to the ViewHolder at the given position.
     *
     * @param holder   The ViewHolder to update.
     * @param position The position of the item in the list.
     */
    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.MealViewHolder holder, int position) {
        // Get the category object at the given position
        Meal meal = meals.get(position);

        // Set category name to the TextView
        holder.strMeal.setText(meal.getStrMeal());
    }

    /**
     * Returns the total number of items in the adapter.
     *
     * @return The number of categories.
     */
    @Override
    public int getItemCount() {
        return meals.size();
    }

    /**
     * ViewHolder class that represents a single item view for a category.
     */
    public static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView strMeal;

        /**
         * Constructor for initializing views inside the ViewHolder.
         *
         * @param itemView The root view of the item layout.
         */
        public MealViewHolder(@NonNull View itemView) {
            super(itemView);

            // Bind views using their IDs from item_category.xml
            strMeal = itemView.findViewById(R.id.meal_name);
        }
    }
}
