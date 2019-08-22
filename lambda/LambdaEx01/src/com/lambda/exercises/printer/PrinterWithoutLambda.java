package com.lambda.exercises.printer;

import com.lambda.exercises.printer.Printer;

public class PrinterWithoutLambda {

Printer p = new Printer() {
    @Override
    public void print() {
        System.out.println("Hi, from without lambda");
    }
};



}
