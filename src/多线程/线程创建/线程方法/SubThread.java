package 多线程.线程创建.线程方法;

public class SubThread extends Thread {
    public SubThread(){
        System.out.println("构造方法打印当前线程名称："+Thread.currentThread().getName());
    }

    //谁调用run谁就是当前线程
    public void run(){

        System.out.println("run方法打印当前线程名称："+Thread.currentThread().getName());
    }
}
