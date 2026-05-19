package org.gfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {

    @Value("#{45+1}")
    int id;
    @Value("Robin")
    String name;
    @Value("robin@gmail.com")
    String email;

    @Autowired
          //  @Qualifier("impl")
    MyInterface myInterface;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public MyInterface getMyInterface() {
        return myInterface;
    }

    public void setMyInterface(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
