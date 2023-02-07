package 多线程.并发访问.Atomics;

import java.util.concurrent.atomic.AtomicStampedReference;

/*
    AtomicStampedReference 原子类可以解决CAS中的ABA问题
    在AtomicStampedReference 原子类中有一个整数标记值stamp, 每次执行CAS 操作时,需
    要对比它的版本,即比较stamp 的值
 */
public class CAS_AtomicStampedReference {
    // private static AtomicReference<String> atomicReference = new AtomicReference<>("abc");

    //定义AtomicStampedReference 引用操作"abc"字符串,指定初始化版本号为0
    private static AtomicStampedReference<String> stamps = new AtomicStampedReference<>("abc",0);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stamps.compareAndSet("abc","def",stamps.getStamp(),stamps.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+"---"+stamps.getReference());
                stamps.compareAndSet("def","abc",stamps.getStamp(),stamps.getStamp()+1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = stamps.getStamp();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(stamps.compareAndSet("abc",
                        "ggg",stamp,stamp+1));

            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stamps.getReference());
    }

}
