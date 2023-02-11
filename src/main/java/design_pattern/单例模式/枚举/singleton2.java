package design_pattern.单例模式.枚举;

public class singleton2 {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.instance;
        Singleton1 instance1 = Singleton1.instance;
        System.out.println(instance==instance1);
        instance.say();
    }
}

/*
    不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 */
enum  Singleton1{
    instance;
    public void say(){
        System.out.println("hello");
    }

}