package ExceptionDeclaration;

import java.io.FileNotFoundException;

public class Child extends Parent{

   /* @Override
    public void m() throws ArithmeticException {
        System.out.println("Child method m()");
    }*/

    @Override
    public void m()  {
        System.out.println("Child method m()");
    }
}
