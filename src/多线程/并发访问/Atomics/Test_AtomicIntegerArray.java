package 多线程.并发访问.Atomics;


import java.util.concurrent.atomic.AtomicIntegerArray;

/*
    在多线程中使用AtomicIntegerArray 原子数组
 */
public class Test_AtomicIntegerArray {
    static java.util.concurrent.atomic.AtomicIntegerArray atomicIntegerArray = new java.util.concurrent.atomic.AtomicIntegerArray(10);
    public static void main(String[] args) {
        System.out.println(atomicIntegerArray);

        //返回元素固定位置
        System.out.println(atomicIntegerArray.get(0));

        //设置指定位置的元素
        atomicIntegerArray.set(0,20);

        //设置并返回
        System.out.println(atomicIntegerArray.getAndSet(0,11));
        System.out.println(atomicIntegerArray);


        //某个元素相加
        System.out.println(atomicIntegerArray.addAndGet(0,22));

        //CAS 操作
        //如果数组中索引值为0的元素的值是33，就修改为222
        System.out.println(atomicIntegerArray.compareAndSet(0,33,222));
        System.out.println(atomicIntegerArray);
    }
}
