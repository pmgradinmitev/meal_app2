package com.example.myapp.endpoints.response;

import com.example.myapp.models.Category;
import java.util.List;

/**
 * Represents the API response for fetching meal categories.
 *
 * This class is used to parse the JSON response from the MealDB API,
 * specifically for the endpoint that retrieves a list of meal categories.
 */
public class CategoriesResponse {

    /**
     * A list of meal categories retrieved from the API.
     * Each category is represented as a {@link Category} object.
     */
    private List<Category> categories;

    /**
     * Getter method to retrieve the list of meal categories.
     *
     * @return A list of {@link Category} objects representing the available meal categories.
     */
    public List<Category> getCategories() {
        return categories;
    }
}
