package 设计模式.工厂模式.工厂方法模式.案例;

public class Client {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        factory.create().record();

        factory = new JavaCourseFactory();
        factory.create().record();
    }
}
