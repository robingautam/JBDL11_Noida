package OOP.Polymorphism;

public class Mathematics {


    // Method Overloading - Compile Time Polymorphism

    public int add(int a, int b){
        return a + b;
    }

    public int add(int a, int b, int c){
        return a + b + c;
    }

    public int add(int a, int b, int c, int d){
        return a + b + c + d;
    }

    public int add(double a, int b){
        return (int)a + b;
    }
}
