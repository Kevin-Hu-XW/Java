package 多线程.并发访问.ReentrantLock.Condition;
/*
    线程交替打印
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class Test01 {
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
                System.out.println(Thread.currentThread().getName()+"  -------------------");
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
                System.out.println(Thread.currentThread().getName()+" *************");
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
        MyService service = new MyService() ;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    service.printOne();
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    service.printTwo();
                }

            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
