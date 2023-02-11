package multithread.并发访问;
/*
    模拟临界资源
 */
public class Data {
    public int n;
    public Data(){
        this.n = 60;
    }
    /*
        synchronized关键字是一个修饰符，可以修饰方法或代码块，其的作用就是，
        对于同一个对象(不是一个类的不同对象)， 当多个线程都同时调用该方法或代码块时，
        必须依次执行，也就是说，如果两个或两个以上的线程同时执行该段代码时，
        如果一个线程已经开始执行该段代码，则另 外一个线程必须等待这个线程执行完这段代码才能开始执行。
     */
    public synchronized void action(String name){
        System.out.println(name+":"+n);
        this.n--;
    }
}
