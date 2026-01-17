package ProdConsProblem;

public class SharedData {

    int data;
    boolean isProduced=false;

    public synchronized void produce(int data){
        if (isProduced){
            try {
                wait();
            }
            catch (Exception e){

            }
        }
        this.data = data;
        System.out.println("Produced: "+data);
        isProduced = true;
        notify();
    }


    public synchronized void consume(){
        if (!isProduced){
            try {
                wait();
            }
            catch (Exception e){

            }
        }
        System.out.println("Consumed: "+this.data);
        isProduced = false;
        notify();
    }
}
