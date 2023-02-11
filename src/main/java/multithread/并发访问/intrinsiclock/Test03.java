package multithread.并发访问.intrinsiclock;

/*
 *只要是同一个锁对象就可以实现同步，与实例方法与静态方法没有有关系
 */

public class Test03 {
    public static void main(String[] args) {
        Test03 test01 = new Test03();
        Test01 test02 = new Test01();
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
        //第三个线程使用静态方法
        new Thread(new Runnable(){
            @Override
            public void run() {

                sm();
            }
        } ).start();
    }
    public static final Object obj =new Object();
    public void mm(){
        synchronized (obj){   //使用一个常量作为锁对象
            for (int i=0;i<20;i++){
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            }
        }

    }
    public static void sm(){
        synchronized (obj){   //使用一个常量作为锁对象
            for (int i=0;i<20;i++){
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            }
        }

    }
}
