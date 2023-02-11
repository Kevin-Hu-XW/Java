package multithread.线程创建.线程方法;

/*
    等待线程运行结束
 */

public class join {
    static  int r = 0;
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        System.out.println(Thread.currentThread().getName()+" 开始");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                r=10;
            }
        });
        t1.start();
        try {
            t1.join();  //等待ti线程运行结束，主线程在运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("r="+r);
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"睡眠1s后，r的值为");
//        System.out.println("r="+r);
    }
}
