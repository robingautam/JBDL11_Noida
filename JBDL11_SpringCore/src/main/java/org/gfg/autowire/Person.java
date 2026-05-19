package org.gfg.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

    int id;
    String name;

   // @Autowired
    Department department;

    public Person(){}

  //  @Autowired
    Person(Department d){
        this.department = d;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    @Autowired
    @Qualifier("department2")
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
