package multithread.并发访问.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//lockInterruptibly() 方法的作用:如果当前线程未被中断则获得锁,如果当前线程被中断则出现异常

public class Test02 {
    static Lock lock = new ReentrantLock();
    public void sm(){
        //在try中获得锁，在finally中释放锁
        try {
            lock.lock();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {

    }
}
