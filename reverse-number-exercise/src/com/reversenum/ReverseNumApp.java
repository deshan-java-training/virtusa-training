package com.reversenum;

public class ReverseNumApp {


    public static void main(String[] args) {

        System.out.println(reverseNum(528));

    }


    public static int reverseNum(int num){

        int rev = 0;
        while (num!=0){
            rev = num%10+rev*10;
            num=num/10;
        }
        return rev;
    }




    }



