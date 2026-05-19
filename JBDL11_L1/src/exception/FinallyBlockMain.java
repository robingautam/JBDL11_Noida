package exception;

public class FinallyBlockMain {

    public static void main(String[] args) {
       /* try {
            System.out.println("Inside try block");
            int result = 10 / 1; // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("This is the finally block. It always executes.");
        }

        System.out.println("Program continues after try-catch-finally.");*/

        FinallyBlockMain obj = new FinallyBlockMain();
        int number = obj.getNumber();
        System.out.println("Returned number: " + number);
    }


    public int getNumber(){
        try {
            return 10;
        } finally {
            System.out.println("Finally block executed in getNumber method.");
            return 5;
        }
    }
}
