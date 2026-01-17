package join;

public class JoinMain {

    public static void main(String[] args) {

        Thread thread = new JoinThread();
        thread.start();
        try {
           thread.join();
        }
        catch (Exception e){

        }

        for (int i=1;i<=10;i++){
            System.out.println("Main - "+i);
        }
    }
}
