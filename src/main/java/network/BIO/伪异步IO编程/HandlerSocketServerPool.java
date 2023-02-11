package network.BIO.伪异步IO编程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerSocketServerPool {
    //创建线程池成员变量，用于存储线程池对象
    private ExecutorService executorService;
    //创建这个类的对象时，完成对线程池的初始化
    public HandlerSocketServerPool(int maxThread,int queueSize){
        /*
            public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue)
         */
        this.executorService = new ThreadPoolExecutor(3,maxThread,120,TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }
    //提供一个方法，来提交任务给线程池的任务队列来暂存，等着线程池来处理
    public void execute(Runnable target){
        executorService.execute(target);
    }
}
