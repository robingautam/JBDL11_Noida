package exception;

public class Keywords {

    public static void main(String[] args) throws Exception{
        // example of custom throw and default catch
        /*int a = 10;
        int b = 0;
        if (b==0){
            throw new ArithmeticException("Denominator cannot be zero");
        }
        int c = a/b;

        System.out.println(c);*/

      /*  try {
            int a = 10;
            int b = 0;
            if (b == 0) {
                throw new ArithmeticException("Denominator cannot be zero");
            }
            System.out.println(a / b);
        }
        catch (Exception e){
            System.out.println("Caught exception: " + e.getMessage());
        }*/

        Keywords obj = new Keywords();
        obj.m();

    }

    public void m() throws Exception{
        int a = 10;
        int b = 0;
        System.out.println(a/b);
    }
}
