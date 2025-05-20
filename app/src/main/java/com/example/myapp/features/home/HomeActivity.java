package com.example.myapp.features.home;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.R;
import com.example.myapp.features.categories.CategoriesActivity;
import com.example.myapp.features.search.SearchActivity;

/**
 * HomeActivity serves as the main entry point of the application.
 *
 * This activity:
 * - Displays the home screen.
 * - Provides navigation to different features, such as viewing meal categories.
 */
public class HomeActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     * Sets up the UI and initializes event listeners.
     *
     * @param savedInstanceState The saved instance state bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Sets the home screen layout

        // Set up button click listener to navigate to CategoriesActivity
        findViewById(R.id.btn_view_categories).setOnClickListener(v ->
                startActivity(new Intent(this, CategoriesActivity.class)));
        findViewById(R.id.btn_search_meal).setOnClickListener(v ->
                startActivity(new Intent(this, SearchActivity.class)));
    }
}
