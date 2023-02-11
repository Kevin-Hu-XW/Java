package design_pattern.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class ProxyTeacher implements InvocationHandler {
    Object target = null;
    public ProxyTeacher(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Throwable {
        System.out.println("代理启动11");
        Object invoke = method.invoke(target, args);  //调用被代理对象的方法
        System.out.println("代理结束22");
        return invoke;
    }
}
