package basic;

public class Person {

    public String name;
    public int age;
    public int height;
    public int weight;
    public String[] skills;
    protected String email;
    protected String mobileNo;
    private String address;
    private long wealth;
    static String collegeName;

    public Person(String n, String e, int a){ // constructor, no args constructor, here java will not create any constructor
        System.out.println("Three args constructor");
        this.name = n;
        this.email = e;
        this.age = a;
    }

    public Person(String n, String e){ // constructor, no args constructor, here java will not create any constructor
        System.out.println("two args constructor");
        name = n;
        email = e;
    }

    public Person(){
        this("Robin","robin@gmail.com");
        System.out.println("Default constructor");

    }

    @Override
    public String toString(){
        return "Person: name="+this.name+", email= "+this.email;
    }


}
