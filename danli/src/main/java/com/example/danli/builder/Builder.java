package com.example.danli.builder;

public abstract class Builder {
    public abstract Builder setBroad(String broad);
    public abstract Builder setDisplay(String display);
    public abstract Builder setOS(String OS);

    public abstract Computer build();
}
