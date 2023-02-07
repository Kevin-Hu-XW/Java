package 多线程.线程创建.Test;

public class TimeBombThread extends Thread {
    public int n;
    public boolean isRun;
    public TimeBombThread() {
        this.n = 60;
        this.isRun = true;
        //启动线程
        this.start();
    }
    public void run() {
            try {
                while (isRun) {
                    Thread.sleep(1000);
                    System.out.println("剩余时间："+n);
                    if (n<=0){
                        //结束线程
                        isRun = false;
                        System.out.println("炸弹爆炸！");
                        break;
                    }
                    n--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
    public void Stop(){
        this.isRun = false;
    }
}
