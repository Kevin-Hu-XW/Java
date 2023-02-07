package 多线程.阻塞队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<String>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "\t put A ");
                    blockingQueue.put("A");

                    System.out.println(Thread.currentThread().getName() + "\t put B ");
                    blockingQueue.put("B");

                    System.out.println(Thread.currentThread().getName() + "\t put C ");
                    blockingQueue.put("C");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t take A ");
                    System.out.println(blockingQueue.take());

                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "\t take B ");
                    System.out.println(blockingQueue.take());

                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "\t take C ");
                    System.out.println(blockingQueue.take());


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();
    }
}
