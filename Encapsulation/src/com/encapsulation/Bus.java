package com.encapsulation;

public class Bus {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Bus(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "color='" + color + '\'' +
                '}';
    }
}
