package multithread.面试.循环打印.wait_notify;
class PrintThread implements Runnable{

    private String name;
    private Object pre;
    private Object self;

    public PrintThread(String name, Object pre, Object self) {
        this.name = name;
        this.pre = pre;
        this.self = self;
    }
    @Override
    public void run() {
        //循环打印ABC5次
        int count = 5;
        while(count>0){
            //pre = A,self =B,释放B锁，阻塞A锁
            synchronized (pre){
                synchronized (self){
                    System.out.print(this.name);
                    count--;
                    //并不会立即释放锁，而是等代码块执行完以后，才会释放锁
                    self.notify();
                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
public class PrintABC {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Object C = new Object();
        //A
        new Thread(new PrintThread("A",A,B)).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //B
        new Thread(new PrintThread("B",B,C)).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //C
        new Thread(new PrintThread("C",C,A)).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
