package org.gfg.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ciconfig.xml");

       Employee employee = applicationContext.getBean("employee", Employee.class);

        System.out.println(employee);
    }
}
