package 多线程.线程通信.wait_notify;


public class Test02 {
    public static void main(String[] args) {
        String lock = new String() ;   //作为锁对象
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("wait  "+System.currentTimeMillis());
                    try {
                        lock.wait();   //当前线程转入blocked阻塞状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait end"+System.currentTimeMillis());
                }

            }
        });
        //第二线程唤醒第一个线程
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("notify "+System.currentTimeMillis());
                    lock.notify();   //唤醒lock锁上等待的某一个线程
                    System.out.println("notify "+System.currentTimeMillis());
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();


    }
}
