package 设计模式.七大软件架构设计原则.依赖倒置;

public class PythonCourse implements ICourse{
    @Override
    public void study() {
        System.out.println("Study Python Course!");
    }
}
