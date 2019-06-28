package com.example.danli.factory2;

import android.util.Log;

public class Square implements Shape{
    private static final String TAG = "Square";
    @Override
    public void draw() {
        Log.e(TAG, "draw: " );
    }
}
