import model.Student;

import java.util.*;

public class SetRunnable {


    public static void main(String[] args) {

        Set<Student> studentSet = new HashSet<Student>();
        Student st1 = new Student(5,"Deshan","Negombo");

        Student st2 = new Student(9,"Marlon","Ekala");
        Student st3 = new Student(8,"Pasindu","Wattala");
        Student st4 = new Student(3,"Aaron","Seeduwa");
        Student st5 = new Student(1,"Suren","Jaela");
        Student st6 = new Student(10,"Dewmi","Kandana");


        Student stdup = new Student(5,"Deshan","Negombo");

        studentSet.add(st1);
        studentSet.add(st2);
        studentSet.add(st3);
        studentSet.add(st4);
        studentSet.add(st5);
        studentSet.add(st6);

        studentSet.add(stdup);


        for(Student s : studentSet){
            System.out.println(s);
        }
    }




}
