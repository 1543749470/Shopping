package com.example.danli.factory2;

public class FactroyProducer {
    public static final int SHAPE=0;
    public static final int COLOR=1;

    public static AbstractFactory getFactory(int type){
        switch (type){
            case SHAPE:
                return new ShapeFactory();
            case COLOR:
                return new ColorFactory();
        }
        return null;
    }
}
