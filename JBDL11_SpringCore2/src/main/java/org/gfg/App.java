package org.gfg;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        Person person = applicationContext.getBean("person", Person.class);

        person.getMyInterface().someTask();

        System.out.println(person);

     //  MyInterface myInterface = applicationContext.getBean("impl", MyInterface.class);

//       myInterface.someTask();
    }
}
