package Hashcode;

public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public boolean equals(Object obj){
        Student that = (Student) obj;
        return this.id == that.id && this.name.equals(that.name);
    }
}
