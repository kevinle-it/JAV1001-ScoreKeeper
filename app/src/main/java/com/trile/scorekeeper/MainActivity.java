package com.trile.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView team1Score;
    TextView team2Score;

    Button btnIncreaseTeam1Score;
    Button btnIncreaseTeam2Score;
    Button btnDecreaseTeam1Score;
    Button btnDecreaseTeam2Score;

    RadioGroup team1ScoreRadioGroup;
    RadioGroup team2ScoreRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --------------------------------------------------
        // Set all references for xml elements
        // --------------------------------------------------
        team1Score = findViewById(R.id.team1Score);
        team2Score = findViewById(R.id.team2Score);

        btnIncreaseTeam1Score = findViewById(R.id.increaseTeam1Score);
        btnIncreaseTeam2Score = findViewById(R.id.increaseTeam2Score);
        btnDecreaseTeam1Score = findViewById(R.id.decreaseTeam1Score);
        btnDecreaseTeam2Score = findViewById(R.id.decreaseTeam2Score);

        team1ScoreRadioGroup = findViewById(R.id.team1ScoreRadioGroup);
        team2ScoreRadioGroup = findViewById(R.id.team2ScoreRadioGroup);
    }
}