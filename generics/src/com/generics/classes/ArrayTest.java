package com.generics.classes;

import java.lang.reflect.Array;

public class ArrayTest {



    public <E> void printArr(E[] array){

        for(E e:array){
            System.out.println(e);
        }
        System.out.println();


    }



}
