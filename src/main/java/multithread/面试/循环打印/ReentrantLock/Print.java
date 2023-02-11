package multithread.面试.循环打印.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Print {
    static class MyService {
        private ReentrantLock lock = new ReentrantLock();
        private Condition c1 = lock.newCondition();
        private boolean flag = false; //控制那个线程先开始执行
        public void printOne(){
            try {
                lock.lock();
                while (flag) {
                    c1.await();
                }
                System.out.println("A");
                flag = true;
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
        public void printTwo(){
            try {
                lock.lock();
                while (!flag) {
                    c1.await();
                }
                System.out.println("B");
                flag = false;
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyService service = new MyService();
            new Thread(() -> {
                while(true){
                    service.printOne();
                }

            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        service.printTwo();
                    }
                }
            }).start();
    }
}
