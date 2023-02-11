package multithread.线程通信.wait_notify;
/*
    wait()会使线程等待，需要放在同步代码块中，通过锁对象调用
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            String lock = new String() ;
            String another = new String() ;
            System.out.println("同步前的代码块");
            synchronized (lock) {
                System.out.println("同步代码块开始...");
                //通过锁调用调用wait()方法后，当前线程就会释放锁，进入阻塞队列
                //当锁对象调用notify()时，当前线程才会进入就绪态，但不会立即运行
                lock.wait();
                //another.wait();   不是锁对象调用会产生异常
            }
            System.out.println("同步代码块结束.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main方法结束......");
    }
}
