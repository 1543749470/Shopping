package com.example.danli.observable;

import java.util.Observable;
//被观察者:产生事件--且通知所有观察者对象更新数据
public class CuiHhua extends Observable {

    String event;

    public String getEvent() {
        return event;
    }
    //产生事件
    public void createEvent(String event){
        this.event=event;
        setChanged();
        notifyObservers();
    }
}
