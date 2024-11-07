package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityBenefits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefits);



        Button Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityBenefits.this, Activity2.class);
            startActivity(intent);
        });
    }
}
