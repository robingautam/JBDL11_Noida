package org.gfg.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person extends User {

    int id;
    String name;
    String email;
    List<String> subjects;
    Set<String> sets;
    Map<String,Integer> marks;
    Address address;

    public Person(){}

    public Person(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subjects=" + subjects +
                ", sets=" + sets +
                ", marks=" + marks +
                ", address=" + address +
                ", userId=" + userId +
                '}';
    }
}
