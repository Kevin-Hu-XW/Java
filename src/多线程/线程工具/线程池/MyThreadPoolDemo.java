package 多线程.线程工具.线程池;


import java.util.concurrent.*;

/*
    第四种获得多线程的方式，线程池
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        /*
            Executor  接口
            Executors    辅助工具类
         */
        //一池5个处理线程
        //ExecutorService threadpool = Executors.newFixedThreadPool(5);

        //一池1线程
        ExecutorService threadpool = Executors.newSingleThreadExecutor();

        //一池N线程
        //ExecutorService threadpool = Executors.newCachedThreadPool();

        // 模拟10个用户来办理业务，每个用户就是一个来自外部请求线程
        try {
            for (int i = 1;i<=10;i++){
                final int tempInt = i;
                threadpool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务");
                    }
                });
                //暂停一会线程
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程
            threadpool.shutdown();
        }

    }
}
