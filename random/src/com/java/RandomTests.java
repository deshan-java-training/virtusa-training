package com.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RandomTests {


    public static void main(String[] args) {
        //printPatternUpto(2);
        //printTableOfNum(9);
        // checkClosestDivisible(-15,6);
       // System.out.println(armStrongNumCheck(371));
        //checkPalindrome(164461);
      //  reverseNum(56879);
        towerOfHanoi();
    }


    public static void printPatternUpto(int n) {
        for (int i = n; i >= 1; i--) {
            System.out.print(i + " " + i + " ");
        }
    }

    public static void printTableOfNum(int n) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter table number: ");
        int table = scn.nextInt();
        System.out.println("Enter times upto: ");
        int times = scn.nextInt();
        for (int i = 1; i <= times; i++) {
            System.out.print(i * table + " ");
        }

    }


    public static void checkClosestDivisible(int x, int y) {
        int num1 = 0;
        for (int i = 1; i < x; i++) {
            if (i % y == 0) {
                num1 = i;
            }
        }

        int num2 = 0;
        for (int n = (x + 10); n >= x; n--) {
            if (n % y == 0) {
                num2 = n;
            }
        }
        if (num1 > num2) {
            System.out.println("Closest max divisible is " + num1);
        } else {
            System.out.println("Closest max divisible is " + num2);
        }
    }

    public static boolean armStrongNumCheck(int num) {
        char[] charArr = Integer.toString(num).toCharArray();
        int totCube = 0;
        int cub = 0;
        if (charArr.length == 3) {

            for (int i = 0; i < charArr.length; i++) {
                cub = Character.getNumericValue(charArr[i]);
                int tot = cub * cub * cub;
                totCube += tot;

            }

        }
        if (totCube == num) {
            return true;
        }
        return false;


    }

public static void checkPalindrome(int i){

        char[] intCha = Integer.toString(i).toCharArray();
        char[] newCha = new char[intCha.length];
int count =0;
        for(int x = intCha.length-1; x>=0; x--){

            newCha[count] = intCha[x];
         count++;
        }

       if(Arrays.equals(intCha, newCha)){
           System.out.println("Number is palindrome");
       }else{
           System.out.println("Number not palindrome");
       }
}


public static void reverseNum(int i){

       String str1 = Integer.toString(i);
    char[] charArr = new char[str1.length()];
    int count = 0;
for(int x = str1.length()-1; x>=0; x--){
    charArr[count] = str1.charAt(x);
    count++;
}
for(char y: charArr){
    System.out.print(y);
}
}
public static void towerOfHanoi(){

    List<Integer> sourceTower = new ArrayList<>();
    List<Integer> spareTower = new ArrayList<>();
    List<Integer> destTower = new ArrayList<>();



    sourceTower.add(1);
    sourceTower.add(2);
    sourceTower.add(3);

    for(Integer i : sourceTower){
        System.out.print(i);
    }

}
}

