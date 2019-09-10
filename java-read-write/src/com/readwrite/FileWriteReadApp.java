package com.readwrite;

import java.io.*;


public class FileWriteReadApp {


    public static void main(String[] args) {
    writeValuesUpTo(15, "/home/user/Desktop/deshan/java-read-write/file-example.txt");
readValuesFromFile("/home/user/Desktop/deshan/java-read-write/file-example.txt");
    }



    public static void writeValuesUpTo(int i, String fileName){
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bf = new BufferedWriter(fw);
            for(int x =1; x<=i; x++){
                bf.write(Integer.toString(x));
                bf.newLine();
            }

            bf.close();

        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("Successfully Written to the file");
    }


public static void readValuesFromFile(String fileName){

        try{
            FileReader fr =new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
String strLine;
            while((strLine=br.readLine()) !=null){
                    System.out.println(strLine);
            }

        }catch (Exception e){
            System.out.println(e);
        }



}


}
