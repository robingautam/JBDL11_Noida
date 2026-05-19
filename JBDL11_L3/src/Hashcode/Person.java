package Hashcode;

public class Person {

    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

  /*  @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return this.id == person.id && this.name.equals(person.name);
    }*/

    @Override
    public int hashCode(){
        return this.name.hashCode()+ this.id;
    }
}
