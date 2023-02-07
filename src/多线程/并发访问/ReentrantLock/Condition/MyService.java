package 多线程.并发访问.ReentrantLock.Condition;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    public ReentrantLock lock = new ReentrantLock() ;
    public Condition c1 = lock.newCondition() ;
    public Condition c2 = lock.newCondition() ;
    public void await_A(){

        try {
            lock.lock();
            System.out.println("A begin");
            c1.await();
            System.out.println("A end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void await_B(){
        try {
            lock.lock();
            System.out.println("B begin");
            c2.await();
            System.out.println("B end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void signal_ALLA(){
        try {
            lock.lock();
            c1.signalAll();
            System.out.println("A wake up");
        }finally {
            lock.unlock();
        }
    }
    public void signal_ALLB(){
        try {
            lock.lock();
            c2.signalAll();
            System.out.println("B wake up");
        }finally {
            lock.unlock();
        }
    }
}
