package multithread.并发访问.ReentrantLock.Condition;
/*
    生产者消费者多对多打印
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test02 {
    static class MyService {
        private ReentrantLock lock = new ReentrantLock();
        private Condition c1 = lock.newCondition() ;
        private Condition c2 = lock.newCondition() ;
        private boolean flag = false;
        public void printOne(){
            try {
                lock.lock();
                while (flag) {
                    c1.await();
                }
                System.out.println(Thread.currentThread().getName()+"  -------------------");
                flag = true;
                c2.signal();
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
                    c2.await();
                }
                System.out.println(Thread.currentThread().getName()+"  *************");
                flag = false;
                c1.signal() ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyService service = new MyService() ;
        for (int i=0;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        service.printOne();
                    }

                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        service.printTwo();
                    }

                }
            }).start();
        }


    }
}
