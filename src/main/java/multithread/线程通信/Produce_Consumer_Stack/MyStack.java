package multithread.线程通信.Produce_Consumer_Stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private List list =new ArrayList();
    private final static  int MaxSize = 1;

    //模拟入栈出栈
    public synchronized void push() {
        //栈中数据已满，请等待
        while (list.size()>MaxSize){
            try {
                System.out.println(Thread.currentThread().getName()+"begin wait...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String data = "data--"+Math.random();
        System.out.println(Thread.currentThread().getName()+"入栈数据"+data);
        list.add(data);
        this.notifyAll();
    }
    //模拟出栈
    public synchronized void pop(){
        //如果没有数据就等待
        while (list.size()<=0){
            System.out.println(Thread.currentThread().getName()+"begin wait...");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"出栈数据"+list.remove(0));
        this.notifyAll();
    }

}
