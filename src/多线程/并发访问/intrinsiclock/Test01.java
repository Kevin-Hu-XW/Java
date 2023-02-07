package 多线程.并发访问.intrinsiclock;

/*
 * synchronized 同步代码块
 * 如果线程的锁不同, 不能实现同步
 * 想要同步必须使用同一个锁对象,不同锁对象则不能实现同步
 */

public class Test01 {
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        //Test01 test02 = new Test01();
        new Thread(new Runnable(){
            @Override
            public void run() {
                test01.mm();
            }
        } ).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                test01.mm();
                //test02.mm();
            }
        } ).start();
    }
    public void mm(){
        synchronized (this){   //经常使用this当前对象作为锁对象
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            }
        }
    }
}
