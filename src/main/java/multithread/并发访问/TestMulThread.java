package multithread.并发访问;

public class TestMulThread {
    public static void main(String[] args) {
        Data data = new Data();
        DataThread dataThread1 = new DataThread(data,"线程1");
        DataThread dataThread2 = new DataThread(data,"线程2");
    }
}
