package multithread.线程创建.Test;
//线程调用是随机的
public class MyThread extends Thread{
    public void run() {
        //获取自定义线程的name
        for (int i=0;i<100;i++) {

            System.out.println("run="+Thread.currentThread().getName());
        }
    }
}
class test{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("myThread");
        //myThread.run();  相当于由main主线程来调用run()方法，也就是必须等待run方法执行完才可以执行后面的代码
        myThread.start();   //相当于让线程规划器安排一个时间来调用Thread中的run方法，具有随机执行的效果
        for (int i=0;i<100;i++) {

            System.out.println("main="+Thread.currentThread().getName());
        }
    }
}