package basic.反射;


import org.junit.Test;


public class newInstance {
    /*
    通过反射创建运行时类的对象
 */
    @Test
    public void test01() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /*
            newInsatnce()：调用此方法，创建对应的运行时类的对象，内部调用了类的空参构造方法
            要想正常创建运行时类的对象，要求：
            1、运行时的来提供空参构造方法
            2、空参构造器的访问权限的够，通常设为public

            javabean中要求提供一个空参构造器，原因：
            1、便于通过反射，创建运行时类的对象
            2、便于子类继承此运行时类，调用super(),保证父类有次构造器
         */
        Person person = clazz.newInstance();
        System.out.println(person);

    }
    /*
        反射的多态性
     */
    @Test
    public void Test02() throws Exception {
            String classpath = "java.lang.Object";
            Object obj  = newinstance(classpath);
            System.out.println(obj);

    }
    public Object newinstance(String classPath) throws Exception {
                Class clazz =  Class.forName(classPath);
                return clazz.newInstance();
    }

}
