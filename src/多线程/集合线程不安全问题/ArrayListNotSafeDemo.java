package 多线程.集合线程不安全问题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;

/*
    集合类线程不安全问题
    ArrayList线程不安全，因为ArrayList的add方法没有加锁，所以线程不安全
    java.util.ConcurrentModificationException
 */
public class ArrayListNotSafeDemo {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(UUID.randomUUID().toString().substring(0, 8));
                    System.out.println(list);

                }
            }).start();
        }


        /*
            1、故障现象
               java.util.ConcurrentModificationException

            2、导致原因
               并发争抢修改导致
               参考争抢花名册，一个人正在写入，另一个同学过来争抢，导致数据不一致异常，并发修改异常

            3、解决方案
               3.1 使用new Vector<>(); 加锁保证线程安全，但并发性降低
               3.2 Collections.synchronizedList(new ArrayList<>());  包装类
               3.3 CopyOnWriteArrayList<>()写时复制的容器，基于读写分离的思想，在往容器里写数据时，不直接往容器里添加数据
                   而是复制一份新的容器，往新的容器里添加数据，在添加完数据后将原容器的引用指向新的容器
                   好处：对CopyOnWrite进行并发的读，而不需要加锁（区别于Vector和Collections.synchronizedList()），因为没有加锁
                         CopyOnWrite容器是一种读写分离的思想，读写是不同的容器

            4、优化建议(同样的错误不烦第二次)
         */
    }
}
