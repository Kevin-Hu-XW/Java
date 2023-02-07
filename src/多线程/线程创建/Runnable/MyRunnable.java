package 多线程.线程创建.Runnable;
/*
    在使用该方式实现时，使需要实现多线程的类实现Runnable，
    实现该接口需要覆盖run方法,然后将需要以多线程方式执行的代码书写在run方法内部或在run方法内部进行调用。
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try{
            for(int i = 0;i < 10;i++){
                Thread.sleep(1000);
                System.out.println("run:" + i);
            }
        }catch(Exception e){}

    }

}
