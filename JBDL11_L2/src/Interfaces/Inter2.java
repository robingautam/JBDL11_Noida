package Interfaces;

public interface Inter2 {
    default void method1() {
        System.out.println("This is method from Inter2");
    }

    void m2();
}
