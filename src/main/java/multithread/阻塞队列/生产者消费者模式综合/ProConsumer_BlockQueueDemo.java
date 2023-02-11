package multithread.阻塞队列.生产者消费者模式综合;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/*
       阻塞队列-----------------生产者消费者3.0版
       线程通信之生产者消费者阻塞队列版
 */
class MyResoource{
    /*
        volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
     */
    // 默认开启，进行生产
    private volatile boolean flag = true;

    // 这里用到了volatile是为了保持数据的可见性，也就是当flag修改时，要马上通知其它线程进行修改
    AtomicInteger atomicInteger = new AtomicInteger();

    // 这里不能为了满足条件，而实例化一个具体的SynchronousBlockingQueue
    BlockingQueue<String> blockingQueue = null;
    public MyResoource(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
        //查询出传入的对象是什么
        System.out.println(blockingQueue.getClass().getName());
    }
    public void Producer() throws InterruptedException {
        String data = "";
        boolean res;
        //多线程一定使用while，防止出现虚假唤醒
        while (flag){
            data = atomicInteger.getAndIncrement()+"";
            res = blockingQueue.offer(data,2L,TimeUnit.SECONDS);
            if (res){
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data  + "成功");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data  + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() +"生产者停止");
    }

    public void Consumer() throws InterruptedException {
        String retValue ;
        boolean res;
        //多线程一定使用while，防止出现虚假唤醒
        while (flag){

            retValue = blockingQueue.poll(2,TimeUnit.SECONDS);
            if (retValue!=null&&retValue!=""){
                System.out.println(Thread.currentThread().getName() + "\t 消费队列:" + retValue  + "成功");
            }
            else {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费失败，队列中已为空，退出" );
                //退出消费队列
                return;
            }
        }
    }

    public void stop(){
        flag = false;
    }


}
public class ProConsumer_BlockQueueDemo {

    public static void main(String[] args){
        MyResoource myResoource = new MyResoource(new ArrayBlockingQueue(5));
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t 生产线程启动\n\n");
                try {
                    myResoource.Producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"producer").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t 生产线程启动\n\n");
                try {
                    myResoource.Consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"consumer").start();

        // 5秒后，停止生产和消费
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n5秒中后，生产和消费线程停止，线程结束");
        myResoource.stop();


    }

}
