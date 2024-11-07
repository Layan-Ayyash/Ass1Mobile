package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PopularRecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_recipes);

        LinearLayout recipesContainer = findViewById(R.id.recipesContainer);
        Button Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(v -> {
            Intent intent = new Intent(PopularRecipesActivity.this, Activity2.class);
            startActivity(intent);
        });
        addRecipe(recipesContainer, R.drawable.quinoa_salad, "Quinoa Salad", "250 cal", "9g protein", "Healthy salad made with quinoa, vegetables, and dressing.");
        addRecipe(recipesContainer, R.drawable.grilled_chicken, "Grilled Chicken", "300 cal", "30g protein", "Juicy grilled chicken breast served with herbs.");
        addRecipe(recipesContainer, R.drawable.oatmeal, "Oatmeal", "150 cal", "6g protein", "Warm oatmeal topped with fruits and nuts.");
        addRecipe(recipesContainer, R.drawable.fruit_smoothie, "Fruit Smoothie", "200 cal", "3g protein", "Refreshing smoothie made with mixed fruits and yogurt.");
    }

    private void addRecipe(LinearLayout container, int imageResId, String name, String calories, String protein, String description) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View recipeView = inflater.inflate(R.layout.recipe_item, container, false);

        ImageView recipeImageView = recipeView.findViewById(R.id.recipeImageView);
        TextView recipeNameTextView = recipeView.findViewById(R.id.recipeNameTextView);
        TextView recipeCaloriesTextView = recipeView.findViewById(R.id.recipeCaloriesTextView);
        TextView recipeProteinTextView = recipeView.findViewById(R.id.recipeProteinTextView);
        Button viewDetailsButton = recipeView.findViewById(R.id.viewDetailsButton);

        recipeImageView.setImageResource(imageResId);
        recipeNameTextView.setText(name);
        recipeCaloriesTextView.setText(calories);
        recipeProteinTextView.setText(protein);

        viewDetailsButton.setOnClickListener(v -> {
            showRecipeDetails(name, calories, protein, description);
        });

        container.addView(recipeView);
    }

    private void showRecipeDetails(String name, String calories, String protein, String description) {
        String details = "Recipe: " + name + "\n" +
                "Calories: " + calories + "\n" +
                "Protein: " + protein + "\n" +
                "Description: " + description;

        new android.app.AlertDialog.Builder(this)
                .setTitle("Recipe Details")
                .setMessage(details)
                .setPositiveButton("OK", null)
                .show();
    }
}
