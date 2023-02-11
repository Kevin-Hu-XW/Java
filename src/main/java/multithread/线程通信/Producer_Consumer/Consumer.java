package multithread.线程通信.Producer_Consumer;

public class Consumer extends Thread{
    private ValueOP valueOP;
    public Consumer(ValueOP valueOP){
        this.valueOP = valueOP;
    }
    @Override
    public void run() {
        super.run();
        while (true) {
            valueOP.getValue();
        }
    }
}
