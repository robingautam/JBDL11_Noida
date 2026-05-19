package second;

import basic.Person;

public class SecondMain {



    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Robin";
        //person.email = ""   // Not accessible outisde the class package its protected nature
    }
}
