package com.example.danli.observable;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class SingleMan implements Observer {
    private static final String TAG = "SingleMan";
    //观察者更新数据
//    @param o
//     * @param arg
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof CuiHhua){
            String event = ((CuiHhua) o).getEvent();
            //业务逻辑
            Log.e(TAG, "update: "+event );
        }
    }
}
