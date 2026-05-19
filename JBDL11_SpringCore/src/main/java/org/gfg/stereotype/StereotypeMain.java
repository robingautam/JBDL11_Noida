package org.gfg.stereotype;

import org.gfg.App;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StereotypeMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/gfg/stereotype/stereotype.xml");

       Employee employee = applicationContext.getBean("employee", Employee.class);

        System.out.println(employee);
    }
}
