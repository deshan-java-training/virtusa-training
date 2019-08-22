package com.lambda.exercises.printer;

public class Application {


    public static void main(String[] args) {

        PrinterWithLambda printLmb = new PrinterWithLambda();
        printLmb.p.print();

        PrinterWithoutLambda printNoLmb = new PrinterWithoutLambda();
        printNoLmb.p.print();

    }
}
