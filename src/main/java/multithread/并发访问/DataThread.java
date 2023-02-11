package multithread.并发访问;
/*
     在多线程编程中，这个是一个典型的临界资源问题，解决这个问题最基本，最简单的思路就是使用同步关键字synchronized。
 */
public class DataThread extends Thread{
    public Data data;
    public String name;
    public DataThread(Data data,String name){
        this.data = data;
        this.name = name;
        this.start();
    }
    public void run(){
        try {
            for (int i=0;i<10;i++) {
                data.action(this.name);
                Thread.sleep(1000);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
