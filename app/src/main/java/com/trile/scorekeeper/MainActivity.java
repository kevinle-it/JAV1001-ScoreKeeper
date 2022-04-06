package com.trile.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
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

    SwitchCompat switchNightMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (((ScoreKeeperApplication) getApplication()).isNightModeEnabled() == true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
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

        switchNightMode = findViewById(R.id.switchNightMode);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            switchNightMode.setChecked(true);
        }

        // --------------------------------------------------
        // Set all listeners for xml elements
        // --------------------------------------------------
        setupButtonListeners();
        setupRadioButtonListeners();
        setupSwitchNightModeListener();
    }

    private void setupButtonListeners() {
        // Increase and Decrease buttons for team 1 and 2 scores
        btnIncreaseTeam1Score.setOnClickListener(view -> {
            team1Score += team1ScoreChangeBy;
            team1ScoreText.setText("Score 1: " + team1Score);
        });
        btnIncreaseTeam2Score.setOnClickListener(view -> {
            team2Score += team2ScoreChangeBy;
            team2ScoreText.setText("Score 2: " + team2Score);
        });
        btnDecreaseTeam1Score.setOnClickListener(view -> {
            team1Score -= team1ScoreChangeBy;
            team1ScoreText.setText("Score 1: " + team1Score);
        });
        btnDecreaseTeam2Score.setOnClickListener(view -> {
            team2Score -= team2ScoreChangeBy;
            team2ScoreText.setText("Score 2: " + team2Score);
        });
    }

    private void setupRadioButtonListeners() {
        // Radio Groups for Team 1 change by score
        team1ScoreRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
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
        });
        // Radio Groups for Team 2 change by score
        team2ScoreRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
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
        });
    }

    private void setupSwitchNightModeListener() {
        switchNightMode.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                ((ScoreKeeperApplication) getApplication()).setIsNightModeEnabled(true);
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivityForResult(intent, 0);
                overridePendingTransition(0,0);
            } else {
                ((ScoreKeeperApplication) getApplication()).setIsNightModeEnabled(false);
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivityForResult(intent, 0);
                overridePendingTransition(0,0);
            }
        });
    }
}