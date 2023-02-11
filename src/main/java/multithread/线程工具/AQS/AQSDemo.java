package multithread.线程工具.AQS;

import java.util.concurrent.locks.ReentrantLock;
/*
    假设 A、B、C 三个人都要去银行窗口办理业务，但是银行窗口只有一个个

 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        // 带入一个银行办理业务的案例来模拟我们的AQS如何进行线程的管理和通知唤醒机制
        // 3个线程模拟3个来银行网点，受理窗口办理业务的顾客
        // A顾客就是第一个顾客，此时受理窗口没有任何人，A可以直接去办理
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}
