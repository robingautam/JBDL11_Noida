package OOP.Polymorphism;

public class Main {

    public static void main(String[] args) {
        // Method Overriding - Run Time Polymorphism
        Parent parent = new Parent();
        parent.showMessage(); // Output: This is the Parent class method.

        Child child = new Child();
        child.showMessage(); // Output: This is the Child class method.

        Parent polyParent = new Child();
        polyParent.showMessage(); // Output: This is the Child class method.

        // Method Overloading - Compile Time Polymorphism
        Mathematics math = new Mathematics();
        System.out.println("Sum of 2 and 3: " + math.add(2, 3)); // Output: 5
        System.out.println("Sum of 2, 3 and 4: " + math.add(2, 3, 4)); // Output: 9
        System.out.println("Sum of 2, 3, 4 and 5: " + math.add(2, 3, 4, 5)); // Output: 14
        System.out.println("Sum of 2.5 and 3: " + math.add(2.5, 3)); // Output: 5
    }
}
