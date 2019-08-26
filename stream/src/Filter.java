import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
    //  printStudentsWithShortNames();
     // filterWithStudents();
     // addDrToStudents();
     // countStudents();
        // maxIdOfStudents();
       // minIdOfStudents();
//sortStudentsWithoutCompareTo();
      //  sortStudentsWithStreamCompareTo();
       // sortWithObjectMethod();
        //reverseObjectsOnId();
        sortWithComparatorImplementation();
    }


    public static void addDrToStudents(){
        Student.getStudents().stream().map(s-> new Student("Dr "+s.getName(),
                s.getId())).collect(Collectors.toList()).forEach(s-> System.out.println(s));

    }
    public static void countStudents(){

long students = Student.getStudents().stream().count();
        System.out.println("Total Number Of Students Are: "+students);
    }

    //Lambda Expressions without Compare
public static void sortStudentsWithoutCompareTo(){

    List<Student> studentL =   Student.getStudents().stream().sorted((s1, s2)-> s1.getId()<s2.getId()?-1:s1.getId()>s2.getId()?1:0).collect(Collectors.toList());
    System.out.println("Sort Without Compare Method");
    System.out.println(studentL);
    System.out.println("**********");
}
// Sort with implemented comparator class

    public static void sortWithComparatorImplementation(){
        List<Student> liStr = Student.getStudents().stream().sorted(new StudentComparator()).collect(Collectors.toList());
        System.out.println("Sort with implemented comparator class");
        System.out.println(liStr);
        System.out.println("**********");
    }



    //Lambda Expressions with Compare
public static void sortStudentsWithStreamCompareTo(){
    System.out.println("Sort With Compare Method");
    List<Student> newL = Student.getStudents().stream().sorted((s1,s2)->new Integer(s1.getId()).compareTo(s2.getId())).collect(Collectors.toList());
    System.out.println(newL);
    System.out.println("**********");
    }

    //With object Method
    public static void sortWithObjectMethod(){
        System.out.println("With object Method");
List<Student> newSt = Student.getStudents().stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
        System.out.println(newSt);
System.out.println("**********");
    }


    //Reverse objects according to id

    public static void reverseObjectsOnId(){
        System.out.println("Reverse objects on ID");
        List<Student> strRev = Student.getStudents().stream().sorted((s1, s2)->-new Integer(s1.getId()).compareTo(s2.getId())).collect(Collectors.toList());
        System.out.println(strRev);
        System.out.println("**********");
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
