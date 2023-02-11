package design_pattern.工厂模式.简单工厂模式.案例;

public class Client {
    public static void main(String[] args) {
        //如果需要增加PythonCourse，则需要修改客户端代码，需要把变得部分与不变的部分分开，需要把这种依赖减弱
        //把创建详解隐藏，需要增加一个简单工厂模式
        ICourse course = new JavaCourse();
        course.record();
    }
}
