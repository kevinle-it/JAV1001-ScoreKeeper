package com.trile.scorekeeper;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ScoreKeeperApplication extends Application {
    public static final String NIGHT_MODE = "NIGHT_MODE";
    private boolean isNightModeEnabled = false;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        this.isNightModeEnabled = pref.getBoolean(NIGHT_MODE, false);
    }

    public boolean isNightModeEnabled() {
        return isNightModeEnabled;
    }

    public void setIsNightModeEnabled(boolean isNightModeEnabled) {
        this.isNightModeEnabled = isNightModeEnabled;

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(NIGHT_MODE, isNightModeEnabled);
        editor.apply();
    }
}
