package 多线程.线程创建.线程方法.线程停止或中断;

public class Mythread extends Thread{
    @Override
    public void run() {
        super.run();

        try {
            for (int i=0;i<1000;i++){
                if (this.isInterrupted()) {
                    System.out.println( "线程已经结束，我要退出" );
                    //break;
                    //return;
                    throw new InterruptedException();
                }
                System.out.println( "i=" + (i + 1) );
            }
            System.out.println( "我是for下面的语句，我被执行说明线程没有真正结束" );
        } catch (InterruptedException e) {
            System.out.println( "进入MyThread.java类中run方法的catch异常了" );
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        try {
            Mythread mythread = new Mythread();
            mythread.start();
            mythread.sleep(2);
            mythread.interrupt();
        } catch (InterruptedException e) {
            System.out.println( "main catch" );
            e.printStackTrace();
        }

    }
}
