package multithread.线程创建.Timer和TimerTask组合;

import java.util.TimerTask;
/*
    以继承TimerTask的方式来实现多线程
 */
public class MyTimerTask extends TimerTask {
    String s;
    public MyTimerTask(String s){
        this.s = s;
    }
    @Override
    public void run() {
        try{
            for(int i = 0;i < 10;i++){
                Thread.sleep(1000);
                System.out.println(s + i);
            }
        }catch(Exception e){}
    }
}
