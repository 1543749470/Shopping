package com.example.danli.template;

import android.util.Log;

public class FootBall extends Game{
    private static final String TAG = "FootBall";
    @Override
    void initialize() {
        Log.e(TAG, "initialize: " );
    }

    @Override
    void startPlay() {
        Log.e(TAG, "startPlay: " );
    }

    @Override
    void endPlay() {
        Log.e(TAG, "endPlay: " );
    }
}
