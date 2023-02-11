package multithread.并发访问.ReentrantLock.ReentrantReadWriteLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/*
    演示ReadWriteLock 的writeLock()写锁是互斥的,只允许有一个线程持有
 */
public class writeLock {
    static class Service{
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        public void write(){

            try {
                readWriteLock.writeLock().lock(); //获得xie锁
                System.out.println(Thread.currentThread().getName() + "开始修改数据时间" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3); //模拟读取数据用时
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }
    }
    public static void main(String[] args) {
        Service service = new Service();
        for (int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.write();
                }
            }).start();
        }
    }
}
