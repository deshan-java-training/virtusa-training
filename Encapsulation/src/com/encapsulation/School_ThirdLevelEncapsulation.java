package com.encapsulation;

import java.util.Enumeration;

public class School_ThirdLevelEncapsulation {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School_ThirdLevelEncapsulation(String name) {
        this.name = name;
    }

    public void getStudentStatus(int num){

        class Students{

            public void getStatus(){

                if(num>500){
                    System.out.println("The School is full");
                }else{
                    System.out.println("The school has capacity");
                }

            }

        }

new Students().getStatus();
    }


}
