package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        Button selectHealthyRecipeButton = findViewById(R.id.selectHealthyRecipeButton);
        selectHealthyRecipeButton.setOnClickListener(v -> {
            Intent intent = new Intent(Activity2.this, Activity3.class);
            startActivity(intent);
        });
        Button openCalorieCalculatorButton = findViewById(R.id.openCalorieCalculatorButton);
        openCalorieCalculatorButton.setOnClickListener(view -> {
            Intent intent = new Intent(Activity2.this, activity_calorie.class);
            startActivity(intent);
        });
        Button viewPopularRecipesButton = findViewById(R.id.viewPopularRecipesButton);
        viewPopularRecipesButton.setOnClickListener(v -> {
            Intent intent = new Intent(Activity2.this, PopularRecipesActivity.class);
            startActivity(intent);
        });

        Button benefitsButton = findViewById(R.id.benefitsButton);
        benefitsButton.setOnClickListener(v -> {
            Intent intent = new Intent(Activity2.this, ActivityBenefits.class);
            startActivity(intent);
        });
        Button fitnessActivitiesButton = findViewById(R.id.SearchButton);
        fitnessActivitiesButton.setOnClickListener(v -> {
            Intent intent = new Intent(Activity2.this, ActivityFitness.class);
            startActivity(intent);
        });


    }
}
