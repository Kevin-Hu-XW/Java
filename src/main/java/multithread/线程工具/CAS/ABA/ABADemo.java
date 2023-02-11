package multithread.线程工具.CAS.ABA;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
    原子引用 + 新增一种机制，那就是修改版本号（类似时间戳），它用来解决ABA问题
 */
public class ABADemo {   //ABA问题的解决   AtomicStampedReference版本号原子引用

    /**
     * 普通的原子引用包装类
     */
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        System.out.println("============以下是ABA问题的产生==========");

        new Thread(() -> {
            // 把100 改成 101 然后在改成100，也就是ABA
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                // 睡眠一秒，保证t1线程，完成了ABA操作
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 把100 改成 101 然后在改成100，也就是ABA
            //System.out.println(atomicReference.compareAndSet(100, 2021) + "\t" + atomicReference.get());

        }, "t2").start();


        System.out.println("============以下是ABA问题的解决==========");


        new Thread(() -> {
            // 把100 改成 101 然后在改成100，也就是ABA
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号" + stamp);
            // 暂停t3 1秒钟，保证t3线程也进行一次ABA问题
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t 第二次版本号" + stampedReference.getStamp());
            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t 第三次版本号" + stampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {
            // 把100 改成 101 然后在改成100，也就是ABA
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号" + stamp);

            // 暂停t4 3秒钟，保证t3线程也进行一次ABA问题
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean res = stampedReference.compareAndSet(100,2021,stamp,stamp+1);

            System.out.println(Thread.currentThread().getName() + "\t 修改成功否：" + res + "\t 当前最新实际版本号："
                    + stampedReference.getStamp());

            System.out.println(Thread.currentThread().getName() + "\t 当前实际最新值" + stampedReference.getReference());
        }, "t4").start();

    }
}
