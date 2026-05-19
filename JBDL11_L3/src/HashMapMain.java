import Hashcode.Person;

import java.util.HashSet;

public class HashMapMain {

    public static void main(String[] args) {
        HashSet<Person> personSet = new HashSet<>();
        Person p1 = new Person(1, "Alice");
        Person p2 = new Person(1, "Alice");
        personSet.add(p1);
        personSet.add(p2);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));


        System.out.println(personSet.size());
    }
}
