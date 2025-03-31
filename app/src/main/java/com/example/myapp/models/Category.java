package com.example.myapp.models;

/**
 * Represents a meal category retrieved from the API.
 *
 * This class is used to store information about a specific meal category,
 * including its ID, name, thumbnail image URL, and description.
 */
public class Category {

    /** Unique identifier for the category */
    private String idCategory;

    /** Name of the category */
    private String strCategory;

    /** URL of the category thumbnail image */
    private String strCategoryThumb;

    /** Description of the category */
    private String strCategoryDescription;

    /**
     * Gets the category ID.
     *
     * @return The unique ID of the category as a String.
     */
    public String getIdCategory() {
        return idCategory;
    }

    /**
     * Gets the category name.
     *
     * @return The name of the category as a String.
     */
    public String getStrCategory() {
        return strCategory;
    }

    /**
     * Gets the URL of the category's thumbnail image.
     *
     * @return A String representing the image URL.
     */
    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    /**
     * Gets the description of the category.
     *
     * @return A String containing the category description.
     */
    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }
}
