package basic;

public class Main {

    public static void main(String[] args){
        Person person = new Person("Robin","robin@gmail.com",27);
//        person.name = "Robin";
//        person.age = 27;
//        person.email = "robingautam1408@gmail.com";
        //person.wealth = ""  // Not accessible outisde the class bcause its private nature
//        Person.collegeName = "MAIT";
//        System.out.println(person.name);
//        System.out.println(person.email);
//        System.out.println(person.age);
//        System.out.println(person.collegeName);

        System.out.println(person.hashCode());
    }

}
