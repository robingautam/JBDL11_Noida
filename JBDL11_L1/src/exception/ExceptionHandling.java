package exception;

public class ExceptionHandling {

    public static void main(String[] args) {
       /* int a = 10;
        int b = 0;
        int c = a/b;
        System.out.println("Line 9"); // Program will end here due to ArithmeticException
        System.out.println(c);*/

      /*  int arr[] = new int[5];
        System.out.println(arr[9]); // Program will end here due to ArrayIndexOutOfBoundsException
        System.out.println("Line 16");*/


        int a = 10;
        int b = 0;

        try {
         //   int c = a/b;
          //  int arr[] = new int[5];
          //  System.out.println(arr[9]);
            String s = null;
            System.out.println(s.length());
            System.out.println("Line 22");
        }
        catch (ArithmeticException e){
            System.out.println(e);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        catch (NullPointerException e){
            System.out.println(e);
        }
        System.out.println("Rest of the code");

        // example for nested try-catch
        try {
           // Code to call 1 API
            try {
                int c = a / b; // This will throw ArithmeticException
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: " + e);
        }
    }
}
