package 多线程.面试.循环打印.wait_notify;
//两个线程使用wait和notify实现循环打印奇偶数
public class Print {
    public static Object lock = new Object();
    public static int i = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (lock){
                        if (i%2==0){
                            System.out.println("偶数线程"+Thread.currentThread().getName()+":"+i++);
                            if (i==20)
                                break;
                            lock.notify(); //唤醒奇数线程
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (lock){
                        if (i%2==1){
                            System.out.println("奇数线程"+Thread.currentThread().getName()+":"+i++);
                            if (i==20)
                                break;
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
//                        else {
//                            try {
//                                lock.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
                    }
                }
            }
        },"t2").start();
    }

}
