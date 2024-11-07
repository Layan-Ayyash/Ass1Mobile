package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String activityName = getIntent().getStringExtra("activityName");
        String activityDescription = getActivityDescription(activityName);

        TextView activityNameTextView = findViewById(R.id.activityNameTextView);
        activityNameTextView.setText(activityName);

        TextView activityDescriptionTextView = findViewById(R.id.activityDescriptionTextView);
        activityDescriptionTextView.setText(activityDescription);
        ImageView activityImageView = findViewById(R.id.activityImageView);
        setActivityImage(activityName, activityImageView);

        Button Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityDetails.this, ActivityFitness.class);
            startActivity(intent);
        });
    }
    private void setActivityImage(String activityName, ImageView imageView) {
        int image;
        switch (activityName) {
            case "Running":
                image = R.drawable.running;
                break;
            case "Yoga":
                image = R.drawable.yoga;
                break;
            case "Jump Rope":
                image = R.drawable.jump_rope;
                break;
            case "Weight Lifting":
                image = R.drawable.weight_lifting;
                break;
            case "Cycling":
                image= R.drawable.cycling;
                break;
            case "Swimming":
                image= R.drawable.swimming;
                break;

            default:
                throw new IllegalStateException(" no image: " + activityName);
        }
        imageView.setImageResource(image); 

    }

    private String getActivityDescription(String activityName) {
        switch (activityName) {
            case "Running":
                return "Running is one of the best exercises for improving cardiovascular fitness and endurance. It helps strengthen bones and promotes muscle growth while being highly effective for burning calories. Additionally, running has mental health benefits by reducing stress and releasing endorphins, often called 'feel-good' hormones, which boost mood and promote a sense of well-being.";
            case "Yoga":
                return "Yoga is more than just a physical exercise; it’s a lifestyle practice that promotes both physical and mental health. Yoga enhances flexibility, strengthens muscles, improves balance, and encourages focus. The deep breathing exercises practiced in yoga help reduce stress and anxiety, fostering self-awareness and promoting a sense of inner peace and relaxation.";
            case "Jump Rope":
                return "Jump rope is an efficient cardio workout that raises the heart rate quickly, enhancing fitness and strengthening muscles. This exercise improves coordination between the hands and eyes and enhances balance. It’s a fun activity suitable for all ages, and it’s great for burning calories fast.";
            case "Weight Lifting":
                return "Weight lifting helps build muscle strength and increase muscle mass, boosting metabolism and supporting fat loss. This activity improves bone density, increases endurance, and promotes joint stability, making it ideal for overall physical health and posture improvement.";
            case "Cycling":
                return "Cycling is excellent for building leg strength and enhancing cardiovascular health. It is a low-impact exercise that can improve endurance, is gentle on the joints, and can be a fun way to explore outdoors or commute while getting fit.";
            case "Swimming":
                return "Swimming is a full-body workout that is gentle on the joints, making it suitable for people of all ages and fitness levels. It strengthens muscles, improves flexibility, and boosts cardiovascular endurance, providing a balanced workout that benefits the entire body.";
            default:
                return "No description available.";
        }
    }
}


