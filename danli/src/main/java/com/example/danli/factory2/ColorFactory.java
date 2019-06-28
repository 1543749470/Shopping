package com.example.danli.factory2;

public class ColorFactory extends AbstractFactory{
    public static final int RED=0;
    public static final int GREEN=1;
    public static final int BLUE=2;
    @Override
    public Shape getShape(int type) {
        return null;
    }

    @Override
    public Color getColor(int type) {
        switch (type){
            case RED:
                return new Red();
            case GREEN:
                return new Green();
            case BLUE:
                return new Blue();
        }
        return null;
    }
}
