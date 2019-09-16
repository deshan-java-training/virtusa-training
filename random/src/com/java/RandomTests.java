package com.java;

import java.util.Scanner;

public class RandomTests {


    public static void main(String[] args) {
        //printPatternUpto(2);
        //printTableOfNum(9);
        checkClosestDivisible(-15,6);
    }


    public static void printPatternUpto(int n){
        for(int i=n;i>=1;i--){
            System.out.print(i+" "+i+" ");
        }
    }

    public static void printTableOfNum(int n){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter table number: ");
        int table = scn.nextInt();
        System.out.println("Enter times upto: ");
        int times =scn.nextInt();
        for(int i =1; i<=times; i++){
            System.out.print(i*table+" ");
        }

    }


    public static void checkClosestDivisible(int x, int y){
        int num1 =0;
        for(int i=1;i<x; i++){
            if(i%y==0){
                num1=i;
            }
        }

        int num2=0;
        for(int n =(x+10); n>=x; n--){
            if(n%y==0){
                num2=n;
            }
        }
        if(num1>num2){
            System.out.println("Closest max divisible is "+num1);
        }else{
            System.out.println("Closest max divisible is "+num2);
        }
    }

}
