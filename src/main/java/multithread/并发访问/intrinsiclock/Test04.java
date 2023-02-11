package multithread.并发访问.intrinsiclock;

/*
 *synchronized同步实例方法
 * 把整个方法体作为同步代码块，默认的锁对象是this 对象
 */

public class Test04 {
    public static void main(String[] args) {
        Test04 test01 = new Test04();
        new Thread(new Runnable(){
            @Override
            public void run() {
                test01.mm();
            }
        } ).start();

        new Thread(new Runnable(){
            @Override
            public void run() {

                test01.mm22();//使用的锁对象this 也是test01对象, 可以同步
                // new Test04().mm22(); 使用的锁对象this是刚刚new 创建的一个新对象,不是同一个锁对象不能同步
            }
        } ).start();

    }


    public void mm(){
        synchronized (this){   //使用一个常量作为锁对象
            for (int i=0;i<20;i++){
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            }
        }

    }
    //使用synchronized 修饰实例方法,同步实例方法, 默认this作为锁对象
    public synchronized void mm22(){

            for (int i=0;i<20;i++){
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            }


    }

}
