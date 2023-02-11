package multithread.线程创建.线程方法;

import java.util.concurrent.TimeUnit;

public class Interrupt {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("enter sleep");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("wake up....");
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        System.out.println("主线程睡眠1s");
        try {
            //Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
