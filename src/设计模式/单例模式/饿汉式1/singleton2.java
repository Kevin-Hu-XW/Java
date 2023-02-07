package 设计模式.单例模式.饿汉式1;

public class singleton2 {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance1 = Singleton1.getInstance();
        System.out.println(instance==instance1);
    }
}
//饿汉式（静态变量）
class Singleton1{
    //构造器私有化，外部不能new
    private Singleton1(){


    }
    //本类内部创建对象实例
    private static Singleton1 instance;
    /*
        这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，
        也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
     */
    static {
        instance = new Singleton1();
    }
    //提供一个公共的静态方法返回实例对象
    public static Singleton1 getInstance(){
        return instance;
    }
}