package 多线程.线程通信.wait_notify;
/*
    线程wait()等待后,可以调用notify()唤醒线程, 如果notify()唤醒的
    过早,在等待之前就调用了notify()可能会打乱程序正常的运行逻辑
    解决办法：notify通知过早就不让线程等待了，通过加一个条件判断
 */
public class Test06 {
    static boolean isfirst = true;
    public static void main(String[] args) {
        final Object Lock = new Object(); //定义对象作为锁对象
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock){
                    while (isfirst){
                        try {
                            System.out.println("begin wait");
                            Lock.wait();
                            System.out.println("wait end...");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock){
                    System.out.println("begin notify");
                    Lock.notify();
                    System.out.println("end nofity");
                    isfirst = false;
                }
            }

        });
        //如果先开启t1,再开启t2 线程创建,大多数情况下, t1 先等待,t2 再把t1 唤醒
        // t1.start();
        // t2.start();
        //如果先开启t2 通知线程,再开启t1 等待线程,可能会出现t1 线程等待没有收到通知的情况,
        t2.start();
        t1.start();
        //实际上,调用start()就是告诉线程调度器,当前线程准备就绪,线程调度器在什么时候开启这个线程不确定,
        // 即调用start()方法的顺序,并不一定就是线程实际开启的顺序.
        //在当前示例中,t1 等待后让t2 线程唤醒, 如果t2 线程先唤醒了,就不让t1线程等待了
    }
}
