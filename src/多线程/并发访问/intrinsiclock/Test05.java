package 多线程.并发访问.intrinsiclock;

/**
 * synchronized 同步静态方法
 * 把整个方法体作为同步代码块
 * 默认的锁对象是当前类的运行时类对象, Test05.class, 有人称它为类锁
 */

public class Test05 {
    public static void main(String[] args) {
        Test05 test01 = new Test05();
        new Thread(new Runnable(){
            @Override
            public void run() {
                test01.mm();
            }
        } ).start();

        new Thread(new Runnable(){
            @Override
            public void run() {

                Test05.mm22();//使用的锁对象是Test05.class
                // new Test04().mm22(); 使用的锁对象this是刚刚new 创建的一个新对象,不是同一个锁对象不能同步
            }
        } ).start();

    }

    //使用当前类的运行时类对象作为锁对象,可以简单的理解为把Test05类的字节码文件作为锁对象
    public void mm(){
        synchronized (Test05.class){
            for (int i=0;i<20;i++){
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            }
        }

    }
    //使用synchronized 修饰静态方法,同步静态方法, 默认运行时类Test05.class 作为锁对象
    public synchronized static void mm22(){

            for (int i=0;i<20;i++){
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            }


    }

}
