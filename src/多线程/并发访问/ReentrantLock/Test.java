package 多线程.并发访问.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/*
    可重入性
 */
public class Test {
    static ReentrantLock lock = new ReentrantLock() ;
    public static void main(String[] args) {
        lock.lock();
        try{
            System.out.println("enter main");
            m1();
        }finally {
            lock.unlock();
        }
    }
    public static void m1(){
        lock.lock();
        try{
            System.out.println("enter m1");
            m2();
        }finally {
            lock.unlock();
        }
    }
    public static void m2(){
        lock.lock();
        try{
            System.out.println("enter m2");

        }finally {
            lock.unlock();
        }
    }
}
