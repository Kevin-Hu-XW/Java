package multithread.并发访问.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class trylock {
    static ReentrantLock lock = new ReentrantLock() ;
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("尝试获得锁");
                try {
                    if (!lock.tryLock(3,TimeUnit.SECONDS)){
                        System.out.println("获取不到锁");
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    System.out.println("获取到锁");
                }finally {
                    lock.unlock();
                }
            }
        });

        lock.lock();
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("释放了锁.....");
        lock.unlock();
    }
}
