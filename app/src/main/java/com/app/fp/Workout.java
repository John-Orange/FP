package com.app.fp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Workout extends AppCompatActivity {

    private String activity;
    private TextView textViewActivity;
    private EditText editTextHours;
    private TextView textViewCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewActivity = findViewById(R.id.textViewActivity);
        editTextHours = findViewById(R.id.editTextHours);
        textViewCalories = findViewById(R.id.textViewCalories);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        activity = getIntent().getStringExtra("activity");
        textViewActivity.setText(activity);

        buttonCalculate.setOnClickListener(v -> calculateCalories());
    }

    private void calculateCalories() {
        String hoursStr = editTextHours.getText().toString();
        if (!hoursStr.isEmpty()) {
            try {
                float hours = Integer.parseInt(hoursStr);
                float caloriesBurned = CaloriesBurned(activity, hours);
                textViewCalories.setText("Calories burned: " + caloriesBurned);
            } catch (NumberFormatException e) {
                editTextHours.setError("Please enter a valid number");
            }
        } else {
            editTextHours.setError("This field cannot be empty");
        }
    }

    private float CaloriesBurned(String activity, float hours) {
        float caloriesPerHour = 0;
        switch (activity) {
            case "Swimming":
                caloriesPerHour = 500;
                break;
            case "Hiking":
                caloriesPerHour = 350;
                break;
            case "Running":
                caloriesPerHour = 600;
                break;
            case "Rowing":
                caloriesPerHour = 400;
                break;
            default:
                caloriesPerHour = 0;
                break;
        }
        return caloriesPerHour * hours;
    }
}
