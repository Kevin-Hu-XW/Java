package 多线程.线程工具.线程池;


import java.util.concurrent.*;


public class CustomerThreadPool {

    public static void main(String[] args) {
        //自定义线程池
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        try {
            for (int i=0;i<8;i++){   //处理业务的最大线程数=线程池最大线程数+队列大小
                final int tempInt = i;
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务");
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }


}
