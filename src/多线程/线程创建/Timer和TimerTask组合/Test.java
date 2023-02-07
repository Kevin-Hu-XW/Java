package 多线程.线程创建.Timer和TimerTask组合;

import java.util.Timer;

/*
    Timer类本身实现的就是一个线程，只是这个线程是用来实现调用其它线程的。
    而TimerTask类是一个抽象类，该类实现了Runnable接口，所以按照前面的介绍，该类具备多线程的能力。

    因为一个Timer启动的多个TimerTask之间会存在影响，当上一个线程未执行完成时，
    会阻塞后续线程的执行，所以当线程1执行完成以后线程2才获得了执行。
    需要线程1和线程2获得同时执行，则只需要分别使用两个Timer启动TimerTask线程即可
 */
public class Test {
    public static void main(String[] args) {
        //创建Timer
        Timer timer = new Timer();
        Timer timer1 = new Timer();
        //创建TimerTask
        MyTimerTask myTimerTask1 = new MyTimerTask("线程1:");
        MyTimerTask myTimerTask2 = new MyTimerTask("线程2:");
        //启动线程
        //schedule方法中的第一个参数mtt1代表需要启动的线程对象，而第二个参数0则代表延迟0毫秒启动该线程，也就是立刻启动。
        timer.schedule(myTimerTask1,1000);
        System.out.println("启动线程1");
        timer1.schedule(myTimerTask2,1000);
        System.out.println("启动线程2");
    }
}
