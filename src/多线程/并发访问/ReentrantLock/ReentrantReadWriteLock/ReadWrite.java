package 多线程.并发访问.ReentrantLock.ReentrantReadWriteLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/*
    一个线程获得读锁时,写线程等待; 一个线程获得写锁时,其他线程等待
 */
public class ReadWrite {
    static class Service{
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        public void read(){
            try {
                readWriteLock.readLock().lock(); //获得读锁
                System.out.println(Thread.currentThread().getName() + "开始时间" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3); //模拟读取数据用时
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readWriteLock.readLock().unlock();
            }
        }
        public void write(){
            try {
                readWriteLock.writeLock().lock(); //获得写锁
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
                    service.read();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.write();
                }
            }).start();
        }
    }
}
