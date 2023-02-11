package design_pattern.单例模式.双重检查;
/*
 */
public class singleton1 {
    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance==instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

//饿汉式（静态变量）
class Singleton{
    //构造器私有化
    private Singleton(){

    }
    /*
        为什么要使用volatile？
        通过使用volatile可以禁止重排序
        在多线程下，防止访问到未初始化的instance对象
        instance= new Singleton();分为一下三步：
        1、给对象分配内存空间
        2、对象的初始化
        3、instance指向内存空间地址
        步骤2、3可能发生重排序，导致在多线程下访问到没有初始化的对象，所以要设置volatile禁止重排序
     */
    private volatile static  Singleton instance ;
    /*
        提供一个静态方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题，同时保证了效率
        1)	Double-Check 概念是多线程开发中常使用到的
            我们进行了两次 if (singleton == null)检查，这样就可以保证线程安全了。
        2)	这样，实例化代码只用执行一次，后面再次访问时，判断 if (singleton == null)，
            直接 return 实例化对象，也避免的反复进行方法同步.
        3)	线程安全；延迟加载；效率较高

        结论：推荐使用
     */
    public static Singleton getInstance(){
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实例
        if (instance==null){
            synchronized (Singleton.class){
                //抢到锁之后再次判断是否为null，防止instance已经被实例化
                if (instance==null)
                    instance= new Singleton();
            }
        }

        return instance;
    }
}