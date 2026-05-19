package org.gfg;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        Student student = new Student();
        student.setId(2);
        student.setName("Aakash");
        student.setEmail("aakash@gmail.com");

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

      //  session.getTransaction().begin();
       // session.save(student);
      //  session.getTransaction().commit();

     //   System.out.println("Data saved");

      /* Student student1 = session.get(Student.class,1);
       student1.setEmail("preeti@gmail.com");
        session.getTransaction().begin();
         session.save(student1);
         session.getTransaction().commit();

        System.out.println("Updated");*/

        Student student1 = session.get(Student.class,1);
        session.getTransaction().begin();
        session.delete(student1);
        session.getTransaction().commit();

        System.out.println("deleted");

    }
}
