package 设计模式.代理模式.动态代理;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //创建目标对象
        ITeacherDao target = new TeacherDao();

        //给目标对象创建代理对象
        ITeacherDao proxy = (ITeacherDao)new ProxyFactory(target).getProxyInstance();
        //通过代理对象，调用目标对象的方法
        proxy.teach();

        //创建invacationhandler对象
        //ProxyTeacher proxyTeacher = new ProxyTeacher(target);

        /*
            public static Object newProxyInstance(ClassLoader loader,
                    Class<?>[] interfaces, InvocationHandler h)

            1. ClassLoader loader ： 指定当前目标对象使用的类加载器, 获取加载器的方法固定
            2. Class<?>[] interfaces:  目标对象实现的接口类型，使用泛型方法确认类型
            3. InvocationHandler h : 事情处理，执行目标对象的方法时，会触发事情处理器方法, 会把当前执行
               的目标对象方法作为参数传入
               InvocationHandler->调用处理程序
         */
        //创建代理对象
//        ITeacherDao instance = (ITeacherDao) Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(), proxyTeacher);
        //通过代理对象调用目标方法
        //instance.sing();

    }
}
