package multithread.面试.循环打印.ReentrantLock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Resource {

    private int number = 1;
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA() {
        try {
            lock.lock();
            while (number != 1) {  //不打印A，condition1阻塞
                condition1.await();
            }
            //number==1,打印A
            System.out.print("A");
            //打印完A，该打印B了，唤醒condition2,并把number设置为2
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        try {
            lock.lock();
            while (number != 2) {
                condition2.await();
            }
            //标志位number=2，打印B
            System.out.print("B");
            //B打印完应该打印C，并把标志位number修改为3，并且唤醒condition3
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        try{
            lock.lock();
            while(number!=3){  //number！=3，不能打印C
                condition3.await();
            }
            System.out.print("C");
            //C打印完需要打印A，并修改标志位number=1，并唤醒condition1
            number = 1;
            condition1.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {

        }
    }
}
//ABC循环打印5次
public class PrintABC {
    public static void main(String[] args) {

        Resource resource = new Resource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    resource.printA();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    resource.printB();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    resource.printC();
                }
            }
        }).start();
    }
}
