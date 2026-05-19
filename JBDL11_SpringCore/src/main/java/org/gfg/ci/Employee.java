package org.gfg.ci;

public class Employee {

    int id;
    String email;
    String name;

    public Employee(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
        System.out.println("int, string , string");
    }

    public Employee(String name, int id, int email) {
        this.id = id;
        this.email = Integer.toString(email);
        this.name = name;
        System.out.println("String, int , int");
    }

    public Employee(String name, String id, int email) {
        this.id = Integer.parseInt(id);
        this.email = Integer.toString(email);
        this.name = name;
        System.out.println("String, String , int");
    }
}
