package 设计模式.单例模式.静态内部类;
public class singleton1 {
    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance==instance2);
        System.out.println("使用静态内部类完成单例模式");
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}
//静态类
class Singleton{
    private Singleton(){

    }
    /*
        静态内部类
        1)	这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
        2)	静态内部类方式在 Singleton1 类被装载时并不会立即实例化，而是在需要实例化时，
            调用 getInstance 方法，才会装载 SingletonInstance 类，从而完成 Singleton1 的实例化。
        3)	类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM 帮助我们保证了线程的安全性，
            在类进行初始化时，别的线程是无法进入的。
        4)	优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高



        如果确实需要对实例字段使用线程安全的延迟初始化，请使用上面介绍的基于 volatile 的延迟初始化的方案；
        如果确实需要对静态字段使用线程安全的延迟初始化，请使用上面介绍的基于类初始化的方案。
     */
    private static class SingletonInner{
        private  static final Singleton instance = new Singleton();
    }
    //提供一个公共的静态方法返回实例对象
    public static Singleton getInstance(){
        return SingletonInner.instance;
    }
}