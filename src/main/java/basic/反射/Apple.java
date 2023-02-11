package basic.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Apple {

private int price;
public int getPrice (){
    return price;
}
public void setPrice (int price){
    this.price = price;
}
    public static void main(String[] args) throws Exception {
        //正常调用
        Apple apple = new Apple();
        apple.setPrice(4);
        System.out.println("Apple Price:"+apple.getPrice());

        //反射调用
        Class<?> clz = Class.forName("basic.反射.Apple");
        /*
            通过 Constructor 对象创建类对象可以选择特定构造方法，而通过 Class 对象则只能使用默认的无参数构造方法
         */
        Constructor appleConstructor = clz.getConstructor();  //根据Class对象实例获取Constructor对象
        Object appleInstance = appleConstructor.newInstance();  //根据Constructor对象的newInstance方法获取反射类对象
        //调用方法，通过Class对象的getMethod()获取Method对象
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        //利用Method对象的invoke()方法调用方法
        setPriceMethod.invoke(appleInstance,15);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple Price:"+getPriceMethod.invoke(appleInstance));

    }
}
