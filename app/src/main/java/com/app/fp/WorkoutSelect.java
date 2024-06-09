package com.app.fp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        findViewById(R.id.buttonSwimming).setOnClickListener(v -> openWorkout("Swimming"));
        findViewById(R.id.buttonHiking).setOnClickListener(v -> openWorkout("Hiking"));
        findViewById(R.id.buttonRunning).setOnClickListener(v -> openWorkout("Running"));
        findViewById(R.id.buttonRowing).setOnClickListener(v -> openWorkout("Rowing"));
    }

    private void openWorkout(String activity) {
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra("activity", activity);
        startActivity(intent);
    }
}
