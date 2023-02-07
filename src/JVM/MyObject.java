package JVM;

public class MyObject {
    public static void main(String[] args) {

        Object object = new Object();
        /*
            实例->模板->类加载器
         */
        System.out.println(object.getClass().getClassLoader()); //结果为null，因为bootstrap是C++语言写的,object是java自带的
        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader());  //MyObject是自己写的，类加载器是AppClassLoader
    }
}
