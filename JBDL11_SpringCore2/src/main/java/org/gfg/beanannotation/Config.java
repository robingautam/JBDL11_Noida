package org.gfg.beanannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {



    @Bean(name = {"p1","p2","p3"})
    public Person getPerson(){
        Person person = new Person();
        person.setEmail("person@gmail.com");
        person.setName("person");
        person.setId(1);
        return person;
    }
}
