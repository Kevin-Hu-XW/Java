package 多线程.并发访问.ReentrantLock.Condition;



public class Test {
    public static void main(String[] args) {
        MyService myService =new MyService();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.await_A();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.await_B();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.signal_ALLA();
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.signal_ALLB();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
