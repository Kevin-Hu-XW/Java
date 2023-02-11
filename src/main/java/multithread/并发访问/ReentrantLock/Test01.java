package multithread.并发访问.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
    可打断
 */
public class Test01 {
    static ReentrantLock lock = new ReentrantLock() ;
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("尝试获得锁");
                    //如果没有竞争，此方法就会获得lock对象的锁
                    //如果有竞争则进入阻塞队列，可以有其他线程通过Interrupt方法打断
                    lock.lockInterruptibly();    //代表该锁可以被打断，避免无限制的等待下去，避免死锁
                } catch (InterruptedException e) {
                    System.out.println("没有获得锁，返回");
                    e.printStackTrace();
                    return;
                }
                try {
                    System.out.println("获得了锁");
                }finally {
                    lock.unlock();
                }
            }
        });
        lock.lock();
        t1.start();

        //1s后主线程将其打断
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("打断...");
        t1.interrupt();
    }
}
