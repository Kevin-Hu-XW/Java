package multithread.线程创建.线程方法;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main 方法中打印当前线程:" + Thread.currentThread().getName());
        SubThread1 subThread1 = new SubThread1();
        //subThread1.setName("t2");   //设置线程的名称
        subThread1.start();
        Thread.sleep(1000);
        //Thread(Runnable)构造方法形参是Runnable接口，调用是接口的实现类对象
        Thread t3 =new Thread(subThread1);
        t3.start();

    }
}
