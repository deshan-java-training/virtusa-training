package com.encapsulation;

public class Car_FirstLevelEncapsulation {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car_FirstLevelEncapsulation(String brand) {
        this.brand = brand;
    }
}
