package com.example.myapp.features.categories.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.myapp.R;
import com.example.myapp.models.Category;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for displaying a list of meal categories in a RecyclerView.
 * This adapter binds category data to the UI and ensures images and names
 * are displayed properly.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    // List of categories to display
    private List<Category> categories = new ArrayList<>();

    /**
     * Updates the category list and refreshes the RecyclerView.
     *
     * @param categories List of categories retrieved from the API.
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a single category item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    /**
     * Binds data to the ViewHolder at the given position.
     *
     * @param holder   The ViewHolder to update.
     * @param position The position of the item in the list.
     */
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        // Get the category object at the given position
        Category category = categories.get(position);

        // Set category name to the TextView
        holder.categoryName.setText(category.getStrCategory());

        // Load category image using Glide for efficient image loading
        Glide.with(holder.categoryImage.getContext())
                .load(category.getStrCategoryThumb())
                .into(holder.categoryImage);
    }

    /**
     * Returns the total number of items in the adapter.
     *
     * @return The number of categories.
     */
    @Override
    public int getItemCount() {
        return categories.size();
    }

    /**
     * ViewHolder class that represents a single item view for a category.
     */
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryImage;

        /**
         * Constructor for initializing views inside the ViewHolder.
         *
         * @param itemView The root view of the item layout.
         */
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            // Bind views using their IDs from item_category.xml
            categoryName = itemView.findViewById(R.id.category_name);
            categoryImage = itemView.findViewById(R.id.category_image);
        }
    }
}
