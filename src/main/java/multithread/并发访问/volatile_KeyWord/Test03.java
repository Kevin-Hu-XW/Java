package multithread.并发访问.volatile_KeyWord;
/*
    volatile 不是具备原子性
 */
public class Test03 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //在main中创建10个子线程
        for (int i=0;i<100;i++) {
            new Thread(myThread).start();
        }
    }
    static class MyThread extends Thread {
        //volatile关键字仅仅表示所有线程从主内存中读取count的值
        private int count;
        /*
        这段代码运行后不是线程安全的,想要线程安全,需要使用synchronized 进行同步,如果使用synchronized 同时,也就不需要volatile 关键了

        public void addCount(){
            for (int i=0;i<100;i++){
                //count++不是原子操作
                count++;
            }
            System.out.println(count);
        }
        */
        synchronized public void addCount(){
            for (int i=0;i<100;i++){
                //count++不是原子操作
                count++;
            }
            System.out.println(count);
        }

        @Override
        public void run() {
            super.run();
            addCount();
        }
    }
}
