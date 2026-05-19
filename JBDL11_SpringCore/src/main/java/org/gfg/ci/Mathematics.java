package org.gfg.ci;

public class Mathematics {

    String num1;
    String num2;

    public Mathematics(double num1, double num2){
        this.num1 = Double.toString(num1);
        this.num2 =Double.toString(num2);

        System.out.println("Inside the double, double");
    }

    public Mathematics(int num1, int num2){
        this.num1 = Integer.toString(num1);
        this.num2 = Integer.toString(num2);

        System.out.println("Inside the int , int");
    }



}
