package com.generics.classes;

import com.generics.interfaces.MotorVehicle;

public class Vehicle<T extends MotorVehicle> {


    T t;

    public Vehicle(T t) {
        this.t = t;
    }


    public void drive(){
        System.out.println(t.toString()+" is driving");
    }

}
