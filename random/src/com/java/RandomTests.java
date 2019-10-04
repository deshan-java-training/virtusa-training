package com.java;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.*;

public class RandomTests {


    public static void main(String[] args) {
        //printPatternUpto(2);
        //printTableOfNum(9);
        // checkClosestDivisible(-15,6);
       // System.out.println(armStrongNumCheck(371));
        //checkPalindrome(164461);
      //  reverseNum(56879);
        //towerOfHanoi();
        //printMultiplesOf(2);
        //int[] intNew = {1,2,3,4,5};
       // reverseArray(intNew);
        //printPowerOf(2, 10);
       // System.out.println(findPowerOf(2,4));
       // loopProb(5,3,5);
   //     leapGame();
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
public static void printMultiplesOf(int i){

        for(int x =1; x<=10; x++){
            System.out.println(i+"  x "+x+" = "+x*i);
        }


}

public static void loopProb(int addinit, int mult, int times){
    int product =0;
    int repval=0;
        for (int i =0; i<=times; i++){
           if(i==0){
            repval+=addinit;
           }
           product = findPowerOf(2, i);
if(product==0){
    product =1;
}

repval=repval+(product*mult);

            System.out.println(repval);
        }


}

    public static void reverseArray(int[] intArr){

        int[] newArray = new int[intArr.length];
        int count =0;
        for(int i=intArr.length-1; i>=0; i--){

            newArray[count] = intArr[i];
            count++;


        }

        for(int a: newArray){
            System.out.print(a);
        }

    }





public static int findPowerOf(int orinum, int times){

        int count =1;
        int product=orinum;

       while (count !=times){
          product*=orinum;
          count++;
       }
       return product;
}

public static void leapGame(){

    Scanner scn = new Scanner(System.in);
    System.out.println("Enter Game Size: ");
        int size = scn.nextInt();
    System.out.println("Enter Leap Size: ");
        int leap = scn.nextInt();
        int count =0;
        int[] intArray = new int[size];
        int strdigit =0;
while(count != (size)){
    System.out.print("Enter game digits (Only 1 & 0): ");
    try {
        strdigit = scn.nextInt();

    }catch (InputMismatchException inpt){
        System.out.println("Input number must only be a integer "+inpt.getCause());
        break;
    }
    if(strdigit !=0 && strdigit!=1){
        throw new RuntimeException("The number must be either 1 or 0");
    }
intArray[count]= strdigit;
    count++;
}
boolean game= false;
for(int x=0; x<intArray.length; x++){

    if(intArray[x]==1){
game=false;
break;
    }else if(intArray[x]==0){
        if((x+leap)>intArray.length){
            game=true;
            break;
        }

    }

}
if(game==true){
    System.out.println("You won the loop challenge");
}else{
    System.out.println("You lost the gaming challenge");
}
}

public static boolean isOdd(int num){





}




}

