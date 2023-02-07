package 多线程.并发访问.intrinsiclock;

/**
 * 死锁
 * 在多线程程序中,同步时可能需要使用多个锁,如果获得锁的顺序
 不一致,可能会导致死锁
 * 如何避免死锁?
 * 当需要获得多个锁时,所有线程获得锁的顺序保持一致即可
 */

public class Test09 {
    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        subThread.setName("a");
        subThread.start();

        SubThread subThread1 = new SubThread();
        subThread1.setName("b");
        subThread1.start();
    }
    static class SubThread extends Thread{
        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();

        @Override
        public void run() {
            super.run();
            if ("a".equals(Thread.currentThread().getName())){
                synchronized (lock1){
                    System.out.println("a 线程获得了lock1 锁,还需要获得lock2 锁");
                    synchronized (lock2){
                        System.out.println("a 线程获得lock1 后又获得了lock2,可以想干任何想干的事");
                    }
                }
            }
            if ("b".equals(Thread.currentThread().getName())){
                synchronized (lock2){
                    System.out.println("b 线程获得了lock2 锁,还需要获得lock1锁");
                    synchronized (lock1){
                        System.out.println("b线程获得lock2后又获得了lock1,可以想干任何想干的事");
                    }
                }
            }
        }
    }



}
