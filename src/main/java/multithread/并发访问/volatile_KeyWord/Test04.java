package multithread.并发访问.volatile_KeyWord;

import java.util.concurrent.atomic.AtomicInteger;

/*
    使用原子类进行自增
 */
public class Test04 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //在main中创建10个子线程
        for (int i=0;i<10;i++) {
            new Thread(myThread).start();
        }
    }
    static class MyThread extends Thread {
        //使用AtomicInteger 对象
        AtomicInteger count = new AtomicInteger(0);

        public void addCount(){
            for (int i=0;i<10;i++){
                count.getAndIncrement();
            }
            System.out.println(count);
        }

        @Override
        public void run() {
            super.run();
            addCount();
        }
    }
}
