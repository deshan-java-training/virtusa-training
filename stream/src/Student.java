import java.util.ArrayList;
import java.util.List;

public class Student {
private String name;
private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, int id){
this.name=name;
this.id=id;
}

    public static List<Student> getStudents(){
List<Student> students = new ArrayList<>();
        students.add(new Student("Pubudu", 4));
        students.add(new Student("Krish", 1));
        students.add(new Student("Thilina", 6));
        students.add(new Student("Namal", 5));
        students.add(new Student("Deshan", 2));
        students.add(new Student("Saman", 3));
        students.add(new Student("Mahesh", 7));
        return students;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
