package 多线程.并发访问.intrinsiclock;

/**
 * 同步方法与同步代码块如何选择
 * 同步方法锁的粒度粗, 执行效率低, 同步代码块锁的粒度细，执行效率高
*/
public class Test06 {
    public static void main(String[] args) {
        Test06 test01 = new Test06();
        new Thread(new Runnable(){
            @Override
            public void run() {
                test01.doLongTimeTask();
            }
        } ).start();

        new Thread(new Runnable(){
            @Override
            public void run() {

                test01.doLongTimeTask2();
            }
        } ).start();

    }

    //同步方法, 执行效率低
    public synchronized void doLongTimeTask(){
        try {
            System.out.println("Task Begin");
            Thread.sleep(3000); //模拟任务需要准备3 秒钟
            System.out.println("开始同步");
            for(int i = 1; i <= 100; i++){
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //同步代码块,锁的粒度细, 执行效率高
    public void doLongTimeTask2(){
        try {
            System.out.println("Task Begin");
            Thread.sleep(3000); //模拟任务需要准备3秒钟

            synchronized (this){
                System.out.println("开始同步");
                for(int i = 1; i <= 100; i++){
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                }
            }
            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
