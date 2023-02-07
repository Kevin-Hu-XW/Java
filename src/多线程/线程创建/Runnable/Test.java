package 多线程.线程创建.Runnable;
/*
    在需要启动线程的地方，首先创建MyRunnable类型的对象，
    然后再以该对象为基础创建Thread类的对象，最后调用Thread对象的start方法即可启动线程
 */
public class Test {
    public static void main(String[] args) {
        //创建对象
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        //启动
        thread.start();
        try{
            for(int i = 0;i < 10;i++){
                Thread.sleep(10000);
                System.out.println("main:" + i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
