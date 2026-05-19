package Hashcode;

public class Main {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(s.hashCode());
        String s1 = "hello";
        System.out.println(s1.hashCode());

        String ref1 = new String("hello");
        String ref2 = "hello";

        System.out.println(ref1.equals(ref2));
        System.out.println(ref1==ref2);

      /*  Person person = new Person();
        person.id = 1;
        person.name = "Alice";

        Person person2 = person;
        //person2.id = 1;
       // person2.name = "Alice";

        System.out.println(person.equals(person2));*/
    }
}
