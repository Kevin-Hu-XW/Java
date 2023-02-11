package multithread.线程工具.线程池;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"****************come in");
        TimeUnit.SECONDS.sleep(5);
        return 1024;
    }
}
public class CallableDemo {

    public static void main(String[] args){
        FutureTask<Integer> futureTask = new FutureTask(new MyThread());
        //FutureTask<Integer> futureTask1 = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
        new Thread(futureTask, "B").start();//多个线程执行 一个FutureTask的时候，只会计算一次
        try {
            //System.out.println(futureTask.get());
            System.out.println(Thread.currentThread().getName()+"**************");
            System.out.println(futureTask.get());   //futureTask.get() 一般希望放在最后面，防止阻塞其他线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
