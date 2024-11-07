package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityFitness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        ListView listView = findViewById(R.id.fitnessActivitiesListView);

        String[] fitnessActivities = {"Running", "Yoga", "Jump Rope", "Weight Lifting", "Cycling", "Swimming"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fitnessActivities);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedActivity = fitnessActivities[position];

            Intent intent = new Intent(ActivityFitness.this, ActivityDetails.class);
            intent.putExtra("activityName", selectedActivity);
            startActivity(intent);
        });

        Button backButton = findViewById(R.id.BackButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityFitness.this, Activity2.class);
            startActivity(intent);
        });
    }
}
