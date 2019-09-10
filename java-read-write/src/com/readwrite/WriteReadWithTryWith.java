package com.readwrite;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteReadWithTryWith {

    public static void main(String[] args) {

        writeWithTryWith(20, "/home/user/Desktop/deshan/java-read-write/try-with-example.txt");
readWithTryWith("/home/user/Desktop/deshan/java-read-write/try-with-example.txt");


    }

    public static void writeWithTryWith(int length, String fileName){

        try(FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
        ){
for(int i=1; i<=length; i++){
    bw.write(Integer.toString(i));
    bw.newLine();
}
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("File Written Successfully");

    }


    public static void readWithTryWith(String filename){

        try(
                FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr);
        ){
            String strLine;

            while ((strLine = br.readLine()) !=null){
                System.out.println(strLine);
            }

        }catch (Exception e){
            System.out.println(e);
        }



    }


}
