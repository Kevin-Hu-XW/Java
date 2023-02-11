package multithread.线程创建.线程方法;

import java.util.concurrent.TimeUnit;
/*
     中断标志可以优雅的退出线程，退不退出线程有用户自己决定
 */
public class isinterrupted {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    boolean isinterrupted = Thread.currentThread().isInterrupted();
                    if (isinterrupted){
                        System.out.println("被打断退出循环");
                        break;
                    }

                }
            }
        });
        t1.start();
        try {
            //Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
