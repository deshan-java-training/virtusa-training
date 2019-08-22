package com.lambda.exercises.printer;

import com.lambda.exercises.printer.Printer;

public class PrinterWithLambda  {


    Printer p = () -> {
        System.out.println("Hi, two");
        System.out.println("Hi, from with lambda");


    };

}
