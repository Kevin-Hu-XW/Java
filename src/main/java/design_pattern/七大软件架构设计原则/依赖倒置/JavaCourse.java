package design_pattern.七大软件架构设计原则.依赖倒置;

public class JavaCourse implements ICourse{
    @Override
    public void study() {
        System.out.println("Study Java Course!");
    }
}
