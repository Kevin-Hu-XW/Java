package 多线程.线程通信.ThreadLocal;

public class Test {
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++) {
                    t1.set("A"+i);
                }
                for (int i=0;i<5;i++) {
                    System.out.println(t1.get());
                }
            }
        }).start();
    }
}
