package com.reversenum;

public class ReverseNumApp {


    public static void main(String[] args) {

    //    System.out.println(reverseNum(528));
reverseNumWithRecursion(5369);
    }


    public static int reverseNum(int num){

        int rev = 0;
        while (num!=0){
            rev = num%10+rev*10;
            num=num/10;
        }
        return rev;
    }

    public static void reverseNumWithRecursion(int i){

        if(i==0){
            return;
        }
        int mod = i%10;
        System.out.print(mod);
        reverseNumWithRecursion(i= i/10);

    }



    }



