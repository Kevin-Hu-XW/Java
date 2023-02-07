package 多线程.并发访问.ReentrantLock.Condition;
/*
    实现场景


    多线程之间按顺序调用，实现 A-> B -> C 三个线程启动，要求如下：
    AA打印5次，BB打印10次，CC打印15次
    紧接着
    AA打印5次，BB打印10次，CC打印15次
    …
    来10轮
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{     //A:1 B:2 C:3
    private int number = 1;
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            //判断
            while (number!=1){
                condition1.await();
            }
            //干活
            for (int i=0;i<1;i++){
                System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" + i);
            }
            number=2; //设置标志位，即该那个线程打印了
            //通知
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            //判断
            while (number!=2){
                condition2.await();
            }
            //干活
            for (int i=0;i<2;i++){
                System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" + i);
            }
            number=3;
            //通知
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            //判断
            while (number!=3){
                condition3.await();
            }
            //干活
            for (int i=0;i<3;i++){
                System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" + i);
            }
            number = 1;
            //通知
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
public class MoreCondition {
    static ShareResource shareResource = new ShareResource();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    shareResource.print5();
                }
            }
        },"AAA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    shareResource.print10();
                }
            }
        },"BBB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    shareResource.print15();
                }
            }
        },"CCC").start();
    }
}
