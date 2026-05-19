package mapping;

import org.gfg.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class MappingMain {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Laptop.class);
        configuration.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setName("Robin");
        user.setEmail("robin@gmail.com");

        Laptop laptop = new Laptop();
        laptop.setLid(1001);
        laptop.setLaptopName("Dell");

        Laptop HP = new Laptop();
        HP.setLid(1002);
        HP.setLaptopName("HP");

        user.setLaptop(Arrays.asList(HP,laptop));

        session.getTransaction().begin();

       // session.save(laptop);
        session.save(user);



        session.getTransaction().commit();

        System.out.println("Data Saved");


    }
}
