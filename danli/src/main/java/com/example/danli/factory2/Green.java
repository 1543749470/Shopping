package com.example.danli.factory2;

import android.util.Log;

public class Green implements Color{

    private static final String TAG = "Green";
    @Override
    public void fill() {
        Log.e(TAG, "fill: 绿" );
    }
}
