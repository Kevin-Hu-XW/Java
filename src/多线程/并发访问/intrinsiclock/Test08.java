package 多线程.并发访问.intrinsiclock;

/**
    同步过程中线程出现异常, 会自动释放锁对象
 */

public class Test08 {
    public static void main(String[] args) {
        Test08 test01 = new Test08();
        new Thread(new Runnable(){
            @Override
            public void run() {
                test01.mm22();
            }
        } ).start();

        new Thread(new Runnable(){
            @Override
            public void run() {

                test01.mm();

            }
        } ).start();

    }

    public void mm(){
        synchronized (Test08.class){   //使用一个常量作为锁对象
            for (int i=0;i<20;i++){
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            }
        }

    }

    public synchronized static void mm22(){
        int i =50;
        if ( i == 50){
            Integer.parseInt("abc"); //把字符串转换为int 类型时,如果字符串不符合数字格式会产生异常
        }


    }

}
