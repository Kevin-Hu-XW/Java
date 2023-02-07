package 多线程.线程工具;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPoolExecutor {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" "+1);
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" "+2);
            }
        });
        pool.execute(()->{
            System.out.println(Thread.currentThread().getName()+" "+3);
        });
    }
}
