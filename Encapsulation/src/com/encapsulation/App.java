package com.encapsulation;

public class App {

    public static void main(String[] args) {
Bus_FourthLevelEncapsulation busFourthLevelEncapsulation = new Bus_FourthLevelEncapsulation();

        busFourthLevelEncapsulation.addBus(busFourthLevelEncapsulation.new Bus("Yellow"));
        busFourthLevelEncapsulation.addBus(busFourthLevelEncapsulation.new Bus("Red"));
        busFourthLevelEncapsulation.addBus(busFourthLevelEncapsulation.new Bus("White"));
        busFourthLevelEncapsulation.addBus(busFourthLevelEncapsulation.new Bus("Maroon"));
        busFourthLevelEncapsulation.addBus(new Bus_FourthLevelEncapsulation().new Bus("Blue"));

        for(Bus_FourthLevelEncapsulation.Bus bus: busFourthLevelEncapsulation.getBusArr()){
            busFourthLevelEncapsulation.validate(bus.getColor());
            System.out.println(bus);
        }

  Animal_SecondLevelEncapsulation animal=      new Animal_SecondLevelEncapsulation("4");
    Animal_SecondLevelEncapsulation.Dog dog = animal.new Dog("bark");
        System.out.println("The dog "+dog.getSound()+" and has legs: "+animal.getLegs());


        School_ThirdLevelEncapsulation sch = new School_ThirdLevelEncapsulation("OKI");

        sch.getStudentStatus(600);

    }
}




