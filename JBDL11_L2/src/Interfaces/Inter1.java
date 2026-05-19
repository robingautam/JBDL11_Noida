package Interfaces;

public interface Inter1 {
    default void method1() {
        System.out.println("This is method from Inter1");
    }

    void m2();
}
