package 设计模式.单例模式.饿汉式;

public class Singleton1 {

    public static void main(String[] args) {//测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }


}
/*
    优点：
        这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
    缺点：
        1、在类装载的时候就完成实例化，没有达到懒加载的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费
        2、这种方式基于 classloder 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，在单例模式中大多数都是
           调用 getInstance 方法， 但是导致类装载的原因有很多种，因此不能确定有其他的方式（或者其他的静态方法）导致类装载，
           这时候初始化 instance 就没有达到 lazy loading 的效果
     类加载的时机:1、创建类的实例，也就是new一个对象
                 2、访问静态变量
                 3、访问静态方法
                 4、反射，Class.forName()
                 5、初始化一个类的子类(会首先初始化子类的父类)
                 6、虚拟机启动时，定义了main()方法的那个类
 */
class Singleton {
    //1. 构造器私有化
    private Singleton(){
    }
    //2.本类内部创建对象实例
    private static Singleton instance = new Singleton();

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() { return instance;
    }

}