package com.generics;

import com.generics.classes.*;

public class Application {


    public static void main(String[] args) {

Bus bus =new Bus();
Car car= new Car();
Dog dog = new Dog();
Vehicle<Bus> bus1 = new Vehicle<>(bus);
Vehicle<Car> car1 = new Vehicle<>(car);
bus1.drive();
car1.drive();

Integer intArr[] = {5,3,8,7,9,4,6};
String strArr[] = {"m","g","y","w","e"};

        ArrayTest arrTest = new ArrayTest();


        arrTest.printArr(intArr);
        arrTest.printArr(strArr);

    }
}
