package multithread.线程通信.wait_notify;
/*
    当线程处于wait()等待状态时, 调用线程对象的interrupt()方法会
    中断线程的等待状态, 会产生InterruptedException 异常
 */
public class Test04 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();
    }

    public static Object lock = new Object() ;
    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            synchronized (lock){
                try {
                    lock.wait();
                    System.out.println("wait....");
                } catch (InterruptedException e) {
                    System.out.println("wait被终止了");
                }
            }
        }
    }
}
