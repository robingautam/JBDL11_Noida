package ProdConsProblem;

public class Consumer extends Thread{

    SharedData sharedData;

    public Consumer(SharedData sharedData){
        this.sharedData = sharedData;
    }

    @Override
    public void run(){
        for (int i=1;i<=10;i++){
            sharedData.consume();
        }
    }
}
