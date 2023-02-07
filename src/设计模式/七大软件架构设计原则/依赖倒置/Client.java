package 设计模式.七大软件架构设计原则.依赖倒置;

public class Client {
    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.setCourse(new JavaCourse());
        tom.study();
    }
}
