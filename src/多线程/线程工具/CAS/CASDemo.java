package 多线程.线程工具.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/*
    比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2021)+"    current value"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"    current value"+atomicInteger.get());
    }
}
