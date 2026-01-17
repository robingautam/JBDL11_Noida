package join;

public class JoinThread extends Thread{

    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            try {
                this.join();
            }
            catch (Exception e){

            }
            System.out.println("Thread - 0 "+i);
        }
    }
}
