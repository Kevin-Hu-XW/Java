package multithread.并发访问.volatile_KeyWord;
/*
    volatile无法保证原子性
 */


import java.util.concurrent.atomic.AtomicInteger;

class MyData2 {
    /**
     * volatile 修饰的关键字，是为了增加 主线程和线程之间的可见性，只要有一个线程修改了内存中的值，其它线程也能马上感知
     */
     volatile int number = 0;


    public void addPlusPlus() {

        number ++;
    }


    AtomicInteger atomicInteger = new AtomicInteger();
    //原子类型的i++
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}
public class Atomic_No {

    public static void main(String[] args) {
        MyData2 myData2 = new MyData2();
        for (int i=0;i<20;i++){
            new Thread(()->{
                for (int j= 0;j<2000;j++){
                    myData2.addPlusPlus();
                    myData2.addAtomic();
                }

            },"BBB").start();
        }
        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
        while(Thread.activeCount() > 2) {
            // yield表示不执行
            Thread.yield();
        }
        System.out.println(myData2.number);
        System.out.println(myData2.atomicInteger);

    }
}
