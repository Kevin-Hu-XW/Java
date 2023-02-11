package multithread.线程通信.wait_notify;

import java.util.ArrayList;
import java.util.List;

public class Test03 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list){
                    try {
                        System.out.println("wait 开始.....");
                        list.wait();
                        System.out.println("wait 结束.....");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list){
                    for (int i=0;i<10;i++){
                        if (list.size()==5){
                            System.out.println("size==5");
                            list.notify();    //唤醒线程，不会立即释放锁对象，需要等到当前同步代码块执行完后才会释放锁对象
                        }
                        list.add(i);
                        System.out.println("size为"+list.size());

                    }

                }
            }
        });

        t1.start();
        /*
            确保t2在t1之后执行，
            使当前线程进入停滞状态（阻塞当前线程），让出CUP的使用、目的是不让当
            前线程独自霸占该进程所获的CPU资源，以留一定时间给其他线程执行的机会;
         */
//        try {
//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t2.start();
    }
}
