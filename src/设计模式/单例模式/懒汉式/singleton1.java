package 设计模式.单例模式.懒汉式;

public class singleton1 {
    public static void main(String[] args) {
        //测试
        System.out.println("懒汉式，线程不安全的！");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance==instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

//饿汉式（静态变量）
class   Singleton{
    //构造器私有化，外部只能new
    private Singleton(){

    }
    //本类内部创建对象实例
    private static Singleton instance;
    //提供一个公有的静态方法，当使用时才创建该instance，线程不安全
    /*  懒汉式 非线程安全
    优点：起到了 Lazy Loading 的效果，但是只能在单线程下使用。
    缺点：在多线程情况下，一个线程进入if判断语句块，还未来的及往下执行，另一个线程也进入判断语句，
          这是便会产生多个实例，破坏了单例模式的设计初衷，所以在多线程情况下不可以使用这种方式
    结论：在实际开发中，不要使用这种方式.
    */
    /*
    public static Singleton1 getInstance(){
        if (instance==null){
            instance = new Singleton1();
        }
        return instance;
    }
    */
    //线程安全，同步方法
    /*
        1)	解决了线程安全问题
        2)	效率太低了，每个线程在想获得类的实例时候，执行 getInstance()方法都要进行同步。
            而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接 return 就行了。
            方法进行同步效率太低
        3)	结论：在实际开发中，不推荐使用这种方式

        public static synchronized Singleton1 getInstance(){
        if (instance==null){
            instance = new Singleton1();
        }
        return instance;
    }

     */
    /*
        线程安全，同步代码块
        但这种同步并不能起到线程同步的作用，与前面非线程安全情况类似
        public static  Singleton1 getInstance(){
        if (instance==null){
            synchronized (Singleton1.class){
                instance = new Singleton1();
            }
        }
        return instance;
    }
    结论：实际开发中不能使用这种方法
     */
    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }

}