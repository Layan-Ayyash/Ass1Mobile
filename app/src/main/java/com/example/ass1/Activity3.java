package com.example.ass1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Activity3 extends AppCompatActivity {

    private EditText searchEditText;
    private Spinner categorySpinner;
    private CheckBox glutenFreeCheckBox, dairyFreeCheckBox;
    private RadioGroup mealTypeRadioGroup;
    private Button searchButton;
    private TextView resultsTextView;
    private List<Recipe> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // Binding UI components
        searchEditText = findViewById(R.id.searchEditText);
        categorySpinner = findViewById(R.id.categorySpinner);
        glutenFreeCheckBox = findViewById(R.id.glutenFreeCheckBox);
        dairyFreeCheckBox = findViewById(R.id.dairyFreeCheckBox);
        mealTypeRadioGroup = findViewById(R.id.mealTypeRadioGroup);
        searchButton = findViewById(R.id.searchButton);
        resultsTextView = findViewById(R.id.resultsTextView);

        populateRecipeList();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Get values from UI components
                String keyword = searchEditText.getText().toString().toLowerCase();
                String category = categorySpinner.getSelectedItem().toString();
                boolean isGlutenFree = glutenFreeCheckBox.isChecked();
                boolean isDairyFree = dairyFreeCheckBox.isChecked();

                int selectedMealTypeId = mealTypeRadioGroup.getCheckedRadioButtonId();
                String mealType = "";
                if (selectedMealTypeId == R.id.breakfastRadioButton) {
                    mealType = "Breakfast";
                } else if (selectedMealTypeId == R.id.lunchRadioButton) {
                    mealType = "Lunch";
                } else if (selectedMealTypeId == R.id.dinnerRadioButton) {
                    mealType = "Dinner";
                }

                List<Recipe> filteredRecipes = new ArrayList<>();
                for (Recipe recipe : recipeList) {
                    boolean matches = true;

                    if (!recipe.getName().toLowerCase().contains(keyword)) {
                        matches = false;
                    }
                    if (!category.equals("All") && !recipe.getCategory().equals(category)) {
                        matches = false;
                    }
                    if (isGlutenFree && !recipe.isGlutenFree()) {
                        matches = false;
                    }
                    if (isDairyFree && !recipe.isDairyFree()) {
                        matches = false;
                    }
                    if (!mealType.isEmpty() && !recipe.getMealType().equals(mealType)) {
                        matches = false;
                    }

                    if (matches) {
                        filteredRecipes.add(recipe);
                    }
                }

                StringBuilder result = new StringBuilder(" Recipes:\n");
                for (Recipe recipe : filteredRecipes) {
                    result.append(recipe.getName()).append("\n");
                }

                if (filteredRecipes.isEmpty()) {
                    result.append("No recipes found.");
                }

                resultsTextView.setText(result.toString());
            }
        });
    }

    private void populateRecipeList() {
        recipeList.add(new Recipe("Quinoa Salad", "Salad", true, true, "Lunch"));
        recipeList.add(new Recipe("Grilled Chicken", "Main Dish", false, true, "Dinner"));
        recipeList.add(new Recipe("Oatmeal", "Breakfast", true, false, "Breakfast"));
        recipeList.add(new Recipe("Fruit Smoothie", "Snack", true, true, "Snack"));
        recipeList.add(new Recipe("Greek Yogurt with Honey", "Dessert", true, true, "Breakfast"));
        recipeList.add(new Recipe("Vegetable Stir Fry", "Main Dish", true, true, "Lunch"));
        recipeList.add(new Recipe("Chia Pudding", "Snack", true, true, "Snack"));
        recipeList.add(new Recipe("Lentil Soup", "Soup", true, true, "Lunch"));
        recipeList.add(new Recipe("Avocado Toast", "Snack", true, true, "Breakfast"));
        recipeList.add(new Recipe("Brown Rice and Vegetables", "Main Dish", true, true, "Dinner"));
        recipeList.add(new Recipe("Green Smoothie", "Drink", true, true, "Snack"));
        recipeList.add(new Recipe("Stuffed Bell Peppers", "Main Dish", true, true, "Dinner"));
        recipeList.add(new Recipe("Kale and Apple Salad", "Salad", true, true, "Lunch"));
        recipeList.add(new Recipe("Baked Sweet Potato", "Side Dish", true, true, "Dinner"));
    }

}