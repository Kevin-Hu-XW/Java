package 网络编程.流.序列化;

import java.io.*;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        //序列化后生成指定文件路径
        //File.separator为'/'，Linux与Windows中不同，为了屏蔽系统的区别所有使用File.separator
        File file= new File("F:"+File.separator+"person.ser");
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(new FileOutputStream(file));
        //把类对象序列化
        Person person =new Person("kevin",20);
        oos.writeObject(person);

        oos.close();

        //反序列化
        ObjectInputStream ois =new ObjectInputStream(new FileInputStream(file));
        Person person1 = (Person) ois.readObject();
        System.out.println(person1.toString());
    }
}
