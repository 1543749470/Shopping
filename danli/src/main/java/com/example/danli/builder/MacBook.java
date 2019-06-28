package com.example.danli.builder;

public class MacBook extends Computer{

    public MacBook(String broad, String display, String os) {
        this.broad=broad;
        this.display=display;
        this.OS=os;
    }

    public static class MacBookBuilder extends Builder{
        private String broad,display,OS;
        @Override
        public Builder setBroad(String broad) {
            this.broad=broad;
            return this;
        }

        @Override
        public Builder setDisplay(String display) {
            this.display=display;
            return this;
        }

        @Override
        public Builder setOS(String OS) {
            this.OS=OS;
            return this;
        }

        @Override
        public Computer build() {
            return new MacBook(broad,display,OS);
        }
    }
}
