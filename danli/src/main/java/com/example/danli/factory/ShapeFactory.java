package com.example.danli.factory;

public class ShapeFactory {
    public static final int CIRCLR=0;
    public static final int SQUARE=1;
    //根据不同类型  生产不同的对象

    public static Shape getShape(int  type){
        switch (type){
            case CIRCLR:
                return new Circle();
            case SQUARE:
                return new Square();
        }
        return null;
    }
}
