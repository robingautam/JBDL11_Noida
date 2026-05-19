package org.gfg;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

       JdbcTemplate jdbcTemplate =  applicationContext.getBean("jdbcTemp", JdbcTemplate.class);

       // insert operation

      //  int rows = jdbcTemplate.update("INSERT INTO student VALUES (?,?,?)",1,"Robin","robin@gmail.com");

      //  int rows = jdbcTemplate.update("UPDATE student set name=? where email=?","Rahul", "robin@gmail.com");

    //  Student student =  jdbcTemplate.queryForObject("select * from student", new StudentMapper());

        int rows = jdbcTemplate.update("delete from student where id = ?",1);

        System.out.println("Row Updated: "+rows);

      //  System.out.println(student);
    }
}
