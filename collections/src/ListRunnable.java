import model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListRunnable {


    public static void main(String[] args) {
        List<String> studentsNames= new ArrayList<>();

        studentsNames.add("John");
        studentsNames.add("Brad");
        studentsNames.add("Nick");
        studentsNames.add("Vass");
        studentsNames.add("Steve");
        studentsNames.add("Adrian");

//
//        for(String s: studentsNames){
//            System.out.println(s);
//        }

        Collections.sort(studentsNames);
        System.out.println("Sorted With String:");
        for(String s: studentsNames){
            System.out.println(s);
        }

List<Student> studentList = new ArrayList<>();
Student stdup1 = new Student(11, "Dup1", "Dup1");



        studentList.add(new Student(5,"Deshan", "Negombo"));
        studentList.add(new Student(8,"Mary", "Wattala"));
        studentList.add(new Student(2,"Nick", "Katunayake"));
        studentList.add(new Student(10,"Fury", "Jaela"));
        studentList.add(new Student(7,"Mahesh", "Gampaha"));
        studentList.add(new Student(3,"Andy", "Jaffna"));

        studentList.add(stdup1);
        studentList.add(stdup1);

        System.out.println("Printing arraylist.Student Objects:");
        for(Student st: studentList){
            System.out.println(st);
        }


    }




}
