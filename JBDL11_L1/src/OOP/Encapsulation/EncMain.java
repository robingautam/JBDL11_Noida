package OOP.Encapsulation;

public class EncMain {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Robin");
        person.setEmail("robin@gmail.com");
      //  person.age = -16;
        person.setAge(-16);
        System.out.println(person.getName());
        System.out.println(person.getAge());


    }
}
