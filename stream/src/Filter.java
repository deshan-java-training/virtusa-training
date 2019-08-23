import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
    //  printStudentsWithShortNames();
     // filterWithStudents();
     // addDrToStudents();
      countStudents();
       maxIdOfStudents();
       minIdOfStudents();
    }


    public static void addDrToStudents(){
        Student.getStudents().stream().map(s-> new Student("Dr "+s.getName(),
                s.getId())).collect(Collectors.toList()).forEach(s-> System.out.println(s));

    }
    public static void countStudents(){

long students = Student.getStudents().stream().count();
        System.out.println("Total Number Of Students Are: "+students);
    }



public static void maxIdOfStudents(){


        Student maxId = Student.getStudents().stream().max((s, s1)->s.getId()>s1.getId()?1:-1).get();
    System.out.println(maxId.getId());
}
    public static void minIdOfStudents(){
        Student minId = Student.getStudents().stream().min((s, s1)->s.getId()>s1.getId()?1:-1).get();
        System.out.println(minId.getId());

    }
    public static void filterWithStudents(){
        List <Student> students = Student.getStudents().stream().filter(s -> s.getName().length()<=6)
                .collect(Collectors.toList());
        System.out.println(students);
    }

    public static void printStudentsWithShortNames(){
        List<Student> students = Student.getStudents();

        for(Student student: students){
            if(student.getName().length()<=6){
                System.out.println(student.getName());

            }
        }

    }
}
