package 多线程.并发访问.案例2;

public class Human extends Thread {
    Toilet t;
    String name;
    public Human(String name,Toilet t){
        this.name = name;
        this.t = t;
        //启动线程
        start();
    }
    public void run(){
        //进入卫生间
        this.t.enter(name);
    }
}
