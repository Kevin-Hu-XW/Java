package 多线程.线程通信.wait_notify;
import java.util.ArrayList;
import java.util.List;
/*
    在使用wait/nofity 模式时,注意wait 条件发生了变化,也可能会造
    成逻辑的混乱

    定义一个集合
    定义一个线程向集合中添加数据,添加完数据后通知另外的线程从集合中取数据
    定义一个线程从集合中取数据,如果集合中没有数据就等待
 */
public class Test07 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                add();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                substract();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                substract();
            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t2.start();
        t3.start();
        t1.start();
    }
    static List list = new ArrayList();
    public static void add(){
        synchronized (list) {
            list.add("data");
            System.out.println(Thread.currentThread().getName()+"添加了一个数据....");
            list.notifyAll(); //唤醒所有线程
        }
    }
    public static void substract(){
        synchronized (list) {
            //if (list.size()==0)
            //当等待的线程被唤醒后, 再判断一次集合中是否有数据可取. 因为可能其他线程会取数据
            // 即需要把sutract()方法中的if 判断改为while
            while (list.size()==0) {
                try {
                    System.out.println(Thread.currentThread().getName()+"begin...");
                    list.wait();
                    System.out.println(Thread.currentThread().getName()+"end...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object data = list.remove(0);
            System.out.println(Thread.currentThread().getName()+"从结合中取出数据"+data+"集合中剩余数据大小为"+list.size());
        }
    }
}
