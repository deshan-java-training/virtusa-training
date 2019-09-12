package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppRun {

    public static void main(String[] args) {

        List<AppObject> newList = new ArrayList<>();

        AppObject.addToList(newList, "Deshan", 23);
        AppObject.addToList(newList, "Krish", 5);
        AppObject.addToList(newList, "Manish", 95);
        AppObject.addToList(newList, "Mike", 20);
        AppObject.addToList(newList, "Tim", 39);

        List<AppObject> list01= newList.stream().filter(s->s.getAppName().equals("Mike")).collect(Collectors.toList());
AppObject.printList(list01);


    Factorial fac = new Factorial();

        System.out.println(fac.findFactorialOf(5));

    }


}
