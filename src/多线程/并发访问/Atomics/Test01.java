package 多线程.并发访问.Atomics;

import java.util.Random;

/*
    模拟服务器请求总数，成功总数，失败总数
 */
public class Test01 {
    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Indicator.getInstace().newRequest();
                    int num = new Random().nextInt();
                    if (num%2==0){
                        Indicator .getInstace() .requestProcessSuccess();
                    }
                    else {
                        Indicator .getInstace().requestProcessFailure();
                    }
                }
            }).start();

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( Indicator.getInstace() .getRequestCount()); //总的请求数
        System.out.println( Indicator.getInstace() .getsuccessCount()); //成功数
        System.out.println( Indicator.getInstace() .getfialureCount()); //失败数
    }
}
