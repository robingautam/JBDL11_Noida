package org.gfg.beanannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

      Person person =  applicationContext.getBean("getPerson", Person.class);

        System.out.println(person);
    }
}
