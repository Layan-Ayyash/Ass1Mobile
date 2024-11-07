package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class activity_calorie extends AppCompatActivity {

    private EditText ageEditText, weightEditText, heightEditText;
    private RadioGroup genderRadioGroup;
    private Spinner activityLevelSpinner;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);

        ageEditText = findViewById(R.id.ageEditText);
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        activityLevelSpinner = findViewById(R.id.activityLevelSpinner);
        resultTextView = findViewById(R.id.resultTextView);

        Button calculateButton = findViewById(R.id.calculateCaloriesButton);
        calculateButton.setOnClickListener(this::calculateCalories);


    }

    private void calculateCalories(View view) {
        try {
            int age = Integer.parseInt(ageEditText.getText().toString());
            double weight = Double.parseDouble(weightEditText.getText().toString());
            double height = Double.parseDouble(heightEditText.getText().toString());

            boolean isMale = genderRadioGroup.getCheckedRadioButtonId() == R.id.maleRadioButton;

            double bmr;
            if (isMale) {
                bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
            } else {
                bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
            }

            String activityLevel = activityLevelSpinner.getSelectedItem().toString();
            double activityMultiplier = 1.2;
            switch (activityLevel) {
                case "Lightly active ":
                    activityMultiplier = 1.375;
                    break;
                case "Moderately active":
                    activityMultiplier = 1.55;
                    break;
                case "Very active ":
                    activityMultiplier = 1.725;
                    break;
                case "Super active ":
                    activityMultiplier = 1.9;
                    break;
            }

            double dailyCalories = bmr * activityMultiplier;
            resultTextView.setText("Your daily calorie needs: " + Math.round(dailyCalories) + " kcal");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please fill in all fields correctly.", Toast.LENGTH_SHORT).show();
        }
    }
}
