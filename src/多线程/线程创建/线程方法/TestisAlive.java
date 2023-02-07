package 多线程.线程创建.线程方法;

public class TestisAlive {
    public static void main(String[] args) throws InterruptedException {
        isAlive thread = new isAlive();
        System.out.println("begain="+thread.isAlive());
        thread.start();
        thread.sleep(1000);
        System.out.println("end="+thread.isAlive());   //结果不确定
    }
}
