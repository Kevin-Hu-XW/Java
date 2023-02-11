package multithread.线程创建.线程方法;

public class isAlive extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("run: isAlive="+this.isAlive());
    }
}
