package com.example.danli.single;

import android.util.Log;

public class SingleTon4 {
    public SingleTon4() {
    }
    public static class Holder{
        public static final  SingleTon4 INSTANCE=new SingleTon4();
    }

    public static SingleTon4 getInstance() {
        return Holder.INSTANCE;
    }

    private static final String TAG = "SingleTon4";
    public void doSomething(){
        Log.e(TAG, "doSomething: " );
    }

}
