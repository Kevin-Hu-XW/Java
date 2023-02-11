package multithread.线程创建.线程安全;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {


    public static void main(String[] args) {
        int num=0;
        System.out.println(num++);
        System.out.println(num);
        myInt m = new myInt();
        for (int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName()+" ->"+m.getint());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
        }
    }

}
class myInt{
    //原子性
    AtomicInteger num = new AtomicInteger();

    synchronized public int getint(){
        /*
           自增操作：1.读取num的值
                    2.num自增
                    3.自增后的值复制给num
         */
        return num.getAndIncrement();
    }
}