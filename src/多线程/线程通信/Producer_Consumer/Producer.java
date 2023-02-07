package 多线程.线程通信.Producer_Consumer;

public class Producer extends Thread{
    private ValueOP valueOP;
    public Producer(ValueOP valueOP){
        this.valueOP = valueOP;
    }
    @Override
    public void run() {
        super.run();
        while (true){
            valueOP.setValue();
        }
    }
}
