package multithread.并发访问.案例2;

public class Toilet {
    /*
    这就相当于一个线程执行到该对象的synchronized方法时，
    就为这个对象加上了一把锁，锁住了这个对象，别的线程在调用该方法时，
    发现了这把锁以后就继续等待下去了。
     */
    public synchronized void enter(String name){
        System.out.println(name+"进入");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"离开");
    }
}
