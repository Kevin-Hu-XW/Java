package 基础.容器.ArrayList.clone;

public class CloneDemo {

    /*
        浅拷贝
        局限性：基本数据类型可以完全复制，引用数据类型则不可以(引用数据类型只是拷贝了一份引用)
        深拷贝：需要重写克隆方法，对引用数据类型进行克隆
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Student stu1 = new Student("kevin",30);
        //调用clone实现数据的拷贝
        Student stu2= (Student) stu1.clone();

        System.out.println(stu1==stu2);
        System.out.println(stu1);
        System.out.println(stu2);

        stu1.setAge(25);
        System.out.println("修改之后------------");
        System.out.println(stu1);
        System.out.println(stu2);
    }
}
