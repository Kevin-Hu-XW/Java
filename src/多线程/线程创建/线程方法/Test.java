package 多线程.线程创建.线程方法;

public class Test {
    public static void main(String[] args) {
        System.out.println("main方法打印当前线程名称："+Thread.currentThread().getName());
        //main方法中调用了构造方法，所以构造方法中的线程就是main线程
        SubThread subThread = new SubThread();
        subThread.start();  //启动子线程，子线程调用run方法
        //subThread.run();  在main 方法中直接调用run()方法,没有开启新的线程,所以在run 方法中的当前线程就是main 线程创建
    }
}
