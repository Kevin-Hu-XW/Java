package 多线程.线程创建.线程方法;

public class SubThread1 extends Thread{
    public SubThread1(){
        System.out.println(" 构造方法中,Thread.currentThread().getName() : " + Thread.currentThread().getName() );
        System.out.println("构造方法,this.getName() : " + this.getName());
    }
    @Override
    public void run() {
        System.out.println("run 方法中,Thread.currentThread().getName() : " +Thread.currentThread().getName() );
        System.out.println("run 方法,this.getName() : " + this.getName());
    }
}
