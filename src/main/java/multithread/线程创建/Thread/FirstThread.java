package multithread.线程创建.Thread;
/*
 * 以继承Thread的方式实现线程
 * 在执行FirstThread类时，和前面的执行流程一样。当执行FirstThread类时，
 * Java虚拟机将开启一个系统线程来执行该类的main方法，main方法的内部代码按照顺序结构进行执行，
 * 首先执行线程对象的初始化，然后执行调用start方法。该行代码的作用是启动线程，
 * 在执行start方法时，不阻塞程序的执行，start方法的调用立刻返回，
 * Java虚拟机以自己的方式启动多线程，开始执行该线程对象的run方法。
 * 同时系统线程的执行流程继续按照顺序执行main方法后续的代码，执行main方法内部的输出。
 *
 * 但该种方式受到Java语法中类的单重继承的限制
 */
public class FirstThread extends Thread {

    public static void main(String[] args) {
        //初始化线程
        FirstThread firstThread = new FirstThread();
        //启动线程
        firstThread.start();
        print("main");
    }
    /*
       run方法内部的代码就是自定义线程代码，或者说，自定义线程的代码必须书写在run方法的内部。
     */
    public void run(){
        print("run");
    }

    private static void print(String s){
        try{
            for(int i = 0;i < 10;i++){
                //延时1秒
                Thread.sleep(1000);
                System.out.println(s + i);
            }

        }catch(Exception e){}
    }
}
