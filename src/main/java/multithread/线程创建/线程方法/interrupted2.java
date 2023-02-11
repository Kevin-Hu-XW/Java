package multithread.线程创建.线程方法;

import java.util.concurrent.TimeUnit;

public class interrupted2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("sleep....");
                    Thread.sleep(5000);   //wait,join被打断后，以异常的方式表示被打断，并把打断标记。标记为false
                    //打断标记可以被用来判断，线程是继续运行还是就此终止
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
