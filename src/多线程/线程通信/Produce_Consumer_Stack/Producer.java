package 多线程.线程通信.Produce_Consumer_Stack;


public class Producer extends Thread{
    private MyStack myStack;
    public Producer(MyStack myStack){
        this.myStack = myStack;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            myStack.push();
        }

    }
}
