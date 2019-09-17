package com.encapsulation;

import java.util.ArrayList;

public class Bus_FourthLevelEncapsulation {

    public  ArrayList<Bus> busArr = new ArrayList<>();


    public ArrayList<Bus> getBusArr() {
        return busArr;
    }

    public void setBusArr(ArrayList<Bus> busArr) {
        this.busArr = busArr;
    }
public void addBus(Bus bus){
        this.busArr.add(bus);
}
public void validate(String color){
        new Object(){
            public void validate(){
                if("Red".equalsIgnoreCase(color)){
                    System.out.println("Valid Color");
                }else{
                    System.out.println("Invalid Color");
                }
        }

    }.validate();
}
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



}
