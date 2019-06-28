package com.example.danli.builder;

public abstract class Computer {
    protected String broad;
    protected String display;
    protected String OS;

    @Override
    public String toString() {
        return "Computer{" +
                "broad='" + broad + '\'' +
                ", display='" + display + '\'' +
                ", OS='" + OS + '\'' +
                '}';
    }
}
