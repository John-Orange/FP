package com.app.fp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonCaloriesBurn).setOnClickListener(v -> openCaloriesBurnActivity());
        findViewById(R.id.buttonBMICalculator).setOnClickListener(v -> openBMICalculatorActivity());
    }

    private void openCaloriesBurnActivity() {
        Intent intent = new Intent(this, WorkoutSelect.class);
        startActivity(intent);
    }

    private void openBMICalculatorActivity() {
        Intent intent = new Intent(this, BMI.class);
        startActivity(intent);
    }
}

