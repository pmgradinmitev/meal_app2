package com.example.myapp.models;
import com.google.gson.annotations.SerializedName;

public class Meal {

    @SerializedName("idMeal")
    private String idMeal;

    @SerializedName("strMeal")
    private String strMeal;

    @SerializedName("strDrinkAlternate")
    private String strDrinkAlternate;

    @SerializedName("strCategory")
    private String strCategory;

    @SerializedName("strArea")
    private String strArea;

    @SerializedName("strInstructions")
    private String strInstructions;

    @SerializedName("strMealThumb")
    private String strMealThumb;

    @SerializedName("strTags")
    private String strTags;

    @SerializedName("strYoutube")
    private String strYoutube;

    // You can add up to strIngredient20 and strMeasure20 if needed
    @SerializedName("strIngredient1")
    private String strIngredient1;

    @SerializedName("strMeasure1")
    private String strMeasure1;

    // Add more ingredients and measures as needed...

    @SerializedName("strSource")
    private String strSource;

    @SerializedName("strImageSource")
    private String strImageSource;

    @SerializedName("strCreativeCommonsConfirmed")
    private String strCreativeCommonsConfirmed;

    @SerializedName("dateModified")
    private String dateModified;

    // Getters and Setters

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    // Add other getters and setters as needed...
}
