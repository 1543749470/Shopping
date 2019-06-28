package com.example.danli.factory;

import android.util.Log;

public class Circle implements Shape{
    private static final String TAG = "Circle";
    @Override
    public void draw() {
        Log.e(TAG, "draw: " );
    }
}
