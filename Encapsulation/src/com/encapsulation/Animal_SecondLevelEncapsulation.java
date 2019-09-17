package com.encapsulation;

public class Animal_SecondLevelEncapsulation {

    private String legs;

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public Animal_SecondLevelEncapsulation(String legs) {
        this.legs = legs;
    }

    public class Dog{

        private String sound;

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

        public Dog(String sound) {
            this.sound = sound;
        }
    }

}
