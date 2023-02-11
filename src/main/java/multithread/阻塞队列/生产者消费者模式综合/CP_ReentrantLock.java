package multithread.阻塞队列.生产者消费者模式综合;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/*
    传统版-----------------生产者消费者2.0版

    一个初始值为0的变量，A,B两个线程实现简单的加1减1，各5次

    1、线程       操作              资源类
    2、判断       干活              通知
    3、防止虚假唤醒机制
 */
class ShareData{
    private volatile int number = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increament(){
        lock.lock();
        try {
            //判断
            while (number!=0){
                //等待，不能生产
                condition.await();
            }
            //生产
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            //通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease(){
        lock.lock();
        try {
            //判断
            while (number==0){
                //等待，不能消费
                condition.await();
            }
            //消费
            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            //通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class CP_ReentrantLock {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    shareData.increament();
                }
            }
        },"AAA").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    shareData.decrease();
                }
            }
        },"BBB").start();
    }
}
