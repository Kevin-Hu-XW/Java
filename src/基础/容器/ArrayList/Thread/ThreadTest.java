package 基础.容器.ArrayList.Thread;

public class ThreadTest {
    public static void main(String[] args) {
        //创建线程任务
        CollectionThread ct = new CollectionThread();
        //开启10条线程
        for (int i = 0; i < 10; i++) {
            new Thread(ct).start();
        }
    }
}
