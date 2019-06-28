package com.example.danli.single;

import android.util.Log;

//懒汉式
public class SingleTon1 {
    private static final String TAG = "SingleTon1";
    //构造函数私有化
    private SingleTon1(){}

    //类名  声明
    private static SingleTon1 singleTon1;
    //提供外部的唯一实例

    public static synchronized SingleTon1 getInstance(){
        if (singleTon1==null){
            singleTon1 = new SingleTon1();
        }
        return singleTon1;
    }
    public void doSomeThing(){
        Log.e(TAG, "doSomeThing: " );
    }


}
