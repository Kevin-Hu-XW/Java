package 基础.容器.ArrayList.Thread;
import java.util.ArrayList;

public class CollectionThread implements Runnable {
    private static ArrayList<String> list = new ArrayList<String>();
    static{
        list.add("Jack");
        list.add("Lucy");
        list.add("Jimmy");
    }
    @Override
    public void run() {
        synchronized (this){
            for (String value : list) {
                System.out.println(value);
                //在读取数据的同时又向集合写入数据
                list.add("coco");
            }
        }

    }
}
