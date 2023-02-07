package 多线程.线程工具.LockSupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) {

        Thread A = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(3000);   //当前线程睡眠，使其他线程获得CPU使用权
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
               LockSupport.park();  //a线程阻塞
               System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒");
           }
       });
        A.setName("A");
        A.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                LockSupport.unpark(A);  //B线程唤醒A线程
                System.out.println(Thread.currentThread().getName() + "\t" + "------通知");

            }
        },"B").start();
    }
}
