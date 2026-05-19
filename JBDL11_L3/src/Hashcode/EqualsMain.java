package Hashcode;

public class EqualsMain {

    public static void main(String[] args) {
        Student student1 = new Student(1, "John");
        Student student2 = new Student(1, "John");

        System.out.println("student1 equals student2: " + student1.equals(student2));
    }
}
