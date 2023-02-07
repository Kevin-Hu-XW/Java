package 多线程.线程创建.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimeBombTimerTask extends TimerTask {
    int n;
    Timer timer;
    boolean isRun;
    public TimeBombTimerTask(){
        this.n = 60;
        this.timer = new Timer();
        this.isRun = true;
        timer.schedule(this,0);
    }
    @Override
    public void run() {
        try {
            while (isRun){
                Thread.sleep(1000);
                System.out.println("剩余时间："+n);
                if (n<=0){
                    //结束线程
                    this.stop();
                    System.out.println("炸弹爆炸！");
                    break;
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void stop(){
        this.isRun = false;
    }
}
