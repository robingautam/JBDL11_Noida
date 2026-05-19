package ExceptionDeclaration;

import java.io.FileNotFoundException;

public class Parent {

   /* public void m(){
        System.out.println("Parent method m()");
    }*/

    public void m() throws FileNotFoundException {
        System.out.println("Parent method m()");
    }
}
