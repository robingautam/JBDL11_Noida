package org.gfg;


import org.gfg.model.FileReader;
import org.gfg.model.Person;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {


        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

     //   ApplicationContext applicationContext = new FileSystemXmlApplicationContext("/Users/robin/Documents/JBDL Notes/config.xml");

        Person person =  applicationContext.getBean("person", Person.class);
       Person person1 = applicationContext.getBean("person", Person.class);

      //  applicationContext.registerShutdownHook();

        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());
        System.out.println(person);

    }
}
