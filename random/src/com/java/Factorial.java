package com.java;

public class Factorial {

    public int findFactorialOf(int i){
        int result = 1;

   for(int x=1; x<=i; x++){
       result = result * x ;
   }

return result;
    }

}
