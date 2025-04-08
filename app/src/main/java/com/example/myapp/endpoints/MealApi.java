package com.example.myapp.endpoints;

import com.example.myapp.endpoints.response.CategoriesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Interface defining API endpoints for fetching meal-related data.
 *
 * This interface is used with Retrofit to perform HTTP requests to the MealDB API.
 */
public interface MealApi {

    /**
     * Retrieves a list of meal categories from the API.
     *
     * API Endpoint: `categories.php`
     *
     * @return A Retrofit {@link Call} object containing the API response,
     *         which will be deserialized into a {@link CategoriesResponse} object.
     */
    @GET("categories.php")
    Call<CategoriesResponse> getCategories();

    @GET("filter.php")
    Call<CategoriesResponse> getMealByMainIngrediant();
}
