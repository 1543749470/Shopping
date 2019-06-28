package com.example.danli.factory2;

public abstract class AbstractFactory {
    public abstract Shape getShape(int type);
    public abstract Color getColor(int type);
}
