package 多线程.线程通信.Produce_Consumer_Stack;
/*
    一生产多消费
 */
public class Test01 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Producer p1 = new Producer(myStack);
        Producer p2 = new Producer(myStack);
        Consumer c1 = new Consumer(myStack);
        Consumer c2 = new Consumer(myStack);
        p1.setName("p1生产者");
        c1.setName("c1消费者");
        c2.setName("c2消费者");
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
