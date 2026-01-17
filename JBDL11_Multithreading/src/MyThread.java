public class MyThread extends Thread{

    @Override
    public void run() {
      //  System.out.println("going to start the thread");
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(i*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}
