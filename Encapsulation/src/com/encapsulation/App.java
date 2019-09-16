package com.encapsulation;

public class App {

    public static void main(String[] args) {
BusStation busStation = new BusStation();

        busStation.addBus(busStation.new Bus("Yellow"));
        busStation.addBus(busStation.new Bus("Red"));
        busStation.addBus(busStation.new Bus("White"));
        busStation.addBus(busStation.new Bus("Maroon"));
        busStation.addBus(new BusStation().new Bus("Blue"));

        for(BusStation.Bus bus: busStation.getBusArr()){
            busStation.validate(bus.getColor());
            System.out.println(bus);
        }


    }
}
