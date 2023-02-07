package 多线程.并发访问.intrinsiclock;

/*
 * synchronized 同步代码块
 * 如果线程的锁不同, 不能实现同步
 * 想要同步必须使用同一个锁对象,不同锁对象则不能实现同步
 */

public class Test02 {
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        Test02 test02 = new Test02();
        new Thread(new Runnable(){
            @Override
            public void run() {
                test01.mm();
            }
        } ).start();

        new Thread(new Runnable(){
            @Override
            public void run() {

                test02.mm();
            }
        } ).start();
    }
    public static final Object obj =new Object();
    public void mm(){
        synchronized (obj){   //使用一个常量作为锁对象
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            }
        }

    }
}
