package multithread.并发访问.ReentrantLock.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用Condition 实现生产者/消费者设计模式, 多对多
public class Test05 {
    static class MyService{
        private Lock lock = new ReentrantLock();  //创建锁对象
        private Condition condition = lock.newCondition();  //创建condition对象
        private boolean flag = true;   //定义交替打印标志

        //定义交替定义方法
        public void printOne(){
            try {
                lock.lock();
                while (flag){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + " -------- ");
                flag=true;
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printTwo(){
            try {
                lock.lock();
                while (!flag){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + " ****** ");
                flag=false;
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
    public static void main(String[] args) {
        MyService myService = new MyService();
        for (int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10;i++){
                        myService.printOne();
                    }

                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10;i++){
                        myService.printTwo();
                    }

                }
            }).start();
        }

    }
}
