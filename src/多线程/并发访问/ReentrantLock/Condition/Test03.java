package 多线程.并发访问.ReentrantLock.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test03 {
    //定义锁
    static Lock lock = new ReentrantLock();
    //创建Condition对象
    static Condition condition =lock.newCondition();


    static class subthread extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                lock.lock();   //使用await前必须获得锁
                System.out.println("method lock");
                condition.await();
                System.out.println("method await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();   //释放锁
                System.out.println("method unlock");
            }

        }
    }
    public static void main(String[] args) {
        subthread subthread = new subthread();
        subthread.start();    //子线程进入等待状态
        try {
            Thread.sleep(3000);  //主线程睡眠3秒后，唤醒子线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(1);
        try {
            lock.lock();
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
