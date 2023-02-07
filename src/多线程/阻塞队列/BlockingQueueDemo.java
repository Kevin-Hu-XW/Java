package 多线程.阻塞队列;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    /*
        1、阻塞队列有没有好的一面

        2、不得不阻塞，你如何管理
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //blockingQueue.add("e");   队列满，无法添加

        //System.out.println(blockingQueue.remove());   队列为空，无法删除

        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
    }
}
