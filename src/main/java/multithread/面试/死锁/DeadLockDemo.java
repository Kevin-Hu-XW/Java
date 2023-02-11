package multithread.面试.死锁;


import java.util.concurrent.TimeUnit;
/*
    thread_A  获取锁的顺序 Lock1 -> Lock2
    thread_B  获取锁的顺序 Lock2 -> Lock1
    造成死锁
    解决办法：1、让线程thread_A和thread_B获取锁的顺序一样
             2、让Lock1=Lock2，即获取同一把锁

    死锁查看工具，检测是否因锁引发程序的崩溃
    Linux 查看进程  ps -ef|grep XXX
    windows下查看java运行程序  jps = java ps     jstack 查看堆栈信息
 */
public class DeadLockDemo {
    public static final String Lock1 = "lock1";
    public static final String Lock2 = "lock2";

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        while (true){
                            synchronized (Lock1){
                                System.out.println(Thread.currentThread().getName() + " 锁住 lock1");
                                TimeUnit.SECONDS.sleep(1);  //使得thread_B锁住Lock2，造成死锁现象
                                synchronized (Lock2){
                                    System.out.println(Thread.currentThread().getName() + " 锁住 lock2");
                                }
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        },"thread_A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        synchronized (Lock2){
                            System.out.println(Thread.currentThread().getName() + " 锁住 lock2");
                            TimeUnit.SECONDS.sleep(1);  //使得thread_A锁住Lock1，造成死锁现象
                            synchronized (Lock1){
                                System.out.println(Thread.currentThread().getName() + " 锁住 lock1");
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread_B").start();

    }
}
