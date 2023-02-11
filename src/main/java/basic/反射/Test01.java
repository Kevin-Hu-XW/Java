package basic.反射;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    直接new还是通过反射创建对象？new
    反射所有场景：编译时不确定对象的类型，就使用反射的方式
    反射与封装性是不是矛盾？
    不矛盾，封装性是建议你如何调用，而反射是能不能调用的问题
    java.lang.Class类的理解：
    1、类加载的过程
    程序结果javac.exe(编译)命令，会生成一个或多个的字节码文件，接着使用javae.exe对某个字节码
    文件进行解释运行。相当于将某个字节码文件加载到内存。此过程称为类的加载，加载到内存中的类称为运行时类
    此时运行时的类就称为Class的实例
    2、Class实例就对应一个运行时的类



    getField
    获取一个类的public成员变量，包括基类。
    getDeclaredField
    获取一个类的 所有成员变量，不包括基类。

    成员变量为private，必须进行此操作->Field.setAccessible


 */
public class Test01 {
    public static void main(String[] args) throws Exception{

        Class c1 =Class.forName("basic.反射.Person");
        System.out.println(c1);
        Class c2 =Class.forName("basic.反射.Person");
        /*
            一个类被加载后只有一个Class对象
            一个类被加载后，类的整个结构都会被封装在Class对象中，
            通过Class对象可以获得类的所有东西
         */
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1==c2);
        //通过反射可以调用对象性的私有构造器、方法、属性
        Person p1 = (Person) c1.newInstance();
        Field age = c1.getDeclaredField("age");
        age.setAccessible(true);
        age.set(p1,20);
        System.out.println(p1);


    }
    @Test
    //获取Class实例的方式
    public void test() throws ClassNotFoundException {
        //方法一：调用运行时类的属性:.class
        Class clazz1 = Person.class;

        //方法二：通过运行时类的对象，调用getClass()方法
        Person  person = new Person();
        Class clazz2 = person.getClass();
        //方法三：调用Class的静态方法
        Class clazz3 = Class.forName("basic.反射.Person");
        //方法四：使用类加载器
        ClassLoader classLoader = Test01.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("basic.反射.Person");

        //获取Person类所有方法信息
        Method[] method = clazz4.getDeclaredMethods();
        for (Method method1:method){
            //System.out.println(method1);
        }
        //获取Person类的所有成员信息
        Field[] fields = clazz4.getFields();
        for (Field field:fields){
            System.out.println(field);
        }
        //获取Person类的所有构造方法
        Constructor[] constructors = clazz4.getConstructors();
        for (Constructor constructor:constructors){
            //System.out.println(constructor);
        }

    }
    @Test
    //利用反射动态创建对象实例
    public void Test04() throws Exception {
        Class clazz = Class.forName("basic.反射.Person1");
        //利用newInstance创建对象
        Person p1 = (Person) clazz.newInstance();
        //利用构造器创建对象
//        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class, int.class);
//        Person p2 = (Person) constructor.newInstance("jack", 1, 2);
//        System.out.println(p1);
//        System.out.println(p2);
//        Method setName = clazz.getDeclaredMethod("setName",String.class);
//        setName.invoke(p1,"tom");
//        System.out.println(p1);
//        Field age = clazz.getDeclaredField("age");
//        age.setAccessible(true);
//        age.set(p1,50);
        System.out.println(p1);

    }
    @Test
    //读取配置文件
    public void Test01() throws IOException {
        Properties properties = new Properties();
        //读取配置文件方式一
//        FileInputStream file = new FileInputStream("E:\\Develop\\Workspaces\\Java基础\\src\\基础\\反射\\jdbc.properties");
//        properties.load(file);
        //读取配置文件方式二
        //文件路径默认位置在module的src下
        ClassLoader classLoader = ClassLoader.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user+": "+password);
    }
}


class Person{
    private String name;
    private int id;
    private int age;

    public Person() {
    }

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}