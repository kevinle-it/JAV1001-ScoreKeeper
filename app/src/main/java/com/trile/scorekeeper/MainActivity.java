package com.trile.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView team1ScoreText;
    TextView team2ScoreText;

    Button btnIncreaseTeam1Score;
    Button btnIncreaseTeam2Score;
    Button btnDecreaseTeam1Score;
    Button btnDecreaseTeam2Score;

    RadioGroup team1ScoreRadioGroup;
    RadioGroup team2ScoreRadioGroup;

    int team1Score = 0; // team 1 score to show on UI
    int team2Score = 0; // team 2 score to show on UI
    int team1ScoreChangeBy = 1; // change by value for team 1 score
    int team2ScoreChangeBy = 1; // change by value for team 2 score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --------------------------------------------------
        // Set all references for xml elements
        // --------------------------------------------------
        team1ScoreText = findViewById(R.id.team1Score);
        team2ScoreText = findViewById(R.id.team2Score);

        btnIncreaseTeam1Score = findViewById(R.id.increaseTeam1Score);
        btnIncreaseTeam2Score = findViewById(R.id.increaseTeam2Score);
        btnDecreaseTeam1Score = findViewById(R.id.decreaseTeam1Score);
        btnDecreaseTeam2Score = findViewById(R.id.decreaseTeam2Score);

        team1ScoreRadioGroup = findViewById(R.id.team1ScoreRadioGroup);
        team2ScoreRadioGroup = findViewById(R.id.team2ScoreRadioGroup);

        // --------------------------------------------------
        // Set all listeners for xml elements
        // --------------------------------------------------
        setupButtonListeners();
        setupRadioButtonListeners();
    }

    private void setupButtonListeners() {
        // Increase and Decrease buttons for team 1 and 2 scores
        btnIncreaseTeam1Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team1Score += team1ScoreChangeBy;
                team1ScoreText.setText("Score 1: " + team1Score);
            }
        });
        btnIncreaseTeam2Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team2Score += team2ScoreChangeBy;
                team2ScoreText.setText("Score 2: " + team2Score);
            }
        });
        btnDecreaseTeam1Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team1Score -= team1ScoreChangeBy;
                team1ScoreText.setText("Score 1: " + team1Score);
            }
        });
        btnDecreaseTeam2Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team2Score -= team2ScoreChangeBy;
                team2ScoreText.setText("Score 2: " + team2Score);
            }
        });
    }

    private void setupRadioButtonListeners() {
        // Radio Groups for Team 1 change by score
        team1ScoreRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Set the change by value for team 1 score when user select a radio button
                switch (checkedId) {
                    case R.id.team1Score1RadioBtn:
                        team1ScoreChangeBy = 1;
                        break;
                    case R.id.team1Score50RadioBtn:
                        team1ScoreChangeBy = 50;
                        break;
                    case R.id.team1Score99RadioBtn:
                        team1ScoreChangeBy = 99;
                        break;
                }
            }
        });
        // Radio Groups for Team 2 change by score
        team2ScoreRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Set the change by value for team 2 score when user select a radio button
                switch (checkedId) {
                    case R.id.team2Score1RadioBtn:
                        team2ScoreChangeBy = 1;
                        break;
                    case R.id.team2Score50RadioBtn:
                        team2ScoreChangeBy = 50;
                        break;
                    case R.id.team2Score99RadioBtn:
                        team2ScoreChangeBy = 99;
                        break;
                }
            }
        });
    }
}