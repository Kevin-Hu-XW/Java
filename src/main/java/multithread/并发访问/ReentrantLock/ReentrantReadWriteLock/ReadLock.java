package multithread.并发访问.ReentrantLock.ReentrantReadWriteLock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/*
    ReadLock 读写锁可以实现多个线程同时读取共享数据,即读
    读共享,可以提高程序的读取数据的效率
 */
public class ReadLock {
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
        }
    }
}
