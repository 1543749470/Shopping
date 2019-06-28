package com.example.danli.factory2;

public class ShapeFactory extends AbstractFactory{
    public static final int CIRCLR=0;
    public static final int SQUARE=1;

    @Override
    public Shape getShape(int type) {
        switch (type){
            case CIRCLR:
                return new Circle();

                case SQUARE:
                return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(int type) {
        return null;
    }
}
