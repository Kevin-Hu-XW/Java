package multithread.集合线程不安全问题;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;


public class ContainsNotSafeDemo {
    public static void main(String[] args) {

        //Set set = new HashSet<String>();
        //Set set = Collections.synchronizedSet(new HashSet<String>());
        /* CopyOnWriteArraySet<>源码：底层是CopyOnWriteArrayList<E>()
            public CopyOnWriteArraySet() {
                al = new CopyOnWriteArrayList<E>();
            }



           HashSet底层是HashMap():初始容量为16，加载因子为0.75
           public HashSet() {
                map = new HashMap<>();
            }
           public boolean add(E e) {
                return map.put(e, PRESENT)==null;
            }
            private static final Object PRESENT = new Object();


         */
        Set set = new CopyOnWriteArraySet<>(new HashSet<String>());
        for (int i=0;i<30;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    set.add(UUID.randomUUID().toString().substring(0, 8));
                    System.out.println(set);
                }
            }).start();
        }
    }
}
