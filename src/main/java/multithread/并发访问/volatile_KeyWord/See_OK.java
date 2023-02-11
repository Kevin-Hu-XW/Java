package multithread.并发访问.volatile_KeyWord;



import java.util.concurrent.TimeUnit;

/*
    volatile关键字是Java提供的一种轻量级同步机制。它能够保证可见性和有序性，但是不能保证原子性。
    在多线程下，对自增和自减volatile无法保证其原子性
    解决办法：1、synchronized锁
             2、使用原子类
 */
class MyData {

    //volatile int number = 0;
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}
/*
    验证可见性
    假设int number = 0， number变量之前没有添加volatile关键字修饰
 */
public class See_OK {


    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // 线程睡眠3秒，假设在进行运算
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);
        },"AAA").start();


        while (myData.number==0){
            // main线程就一直在这里等待循环，直到number的值不等于零
        }
        System.out.println(myData.number);
    }

}
