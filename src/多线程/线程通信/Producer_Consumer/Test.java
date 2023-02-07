package 多线程.线程通信.Producer_Consumer;

public class Test {
    public static void main(String[] args) {
        ValueOP valueOP = new ValueOP();
        Producer p1 = new Producer(valueOP);
        Producer p2 = new Producer(valueOP);
        Consumer c1 = new Consumer(valueOP);
        Consumer c2 = new Consumer(valueOP);
        p1.setName("p1生产者");
        p2.setName("p2生产者");
        c1.setName("c1消费者");
        c2.setName("c2消费者");
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
