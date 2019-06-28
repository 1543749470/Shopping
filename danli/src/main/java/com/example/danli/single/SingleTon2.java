package com.example.danli.single;

import android.util.Log;

public class SingleTon2 {
    private static final String TAG = "SingleTon2";

    //构造函数私有化


    public SingleTon2() {}

    public static SingleTon2 singleTon2= new SingleTon2();


    public static synchronized SingleTon2 getInstance() {
        return singleTon2;
    }
    public void doSomething(){
        Log.e(TAG, "doSomething: " );
    }
}
