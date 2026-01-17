public class Main {

    public static void main(String[] args) {
       Thread thread = new MyThread(); // 1 thread
       thread.start();
     //  thread.start();

       for (int i=1;i<=10;i++){
           System.out.print(i+" ");
       }
    }
}
