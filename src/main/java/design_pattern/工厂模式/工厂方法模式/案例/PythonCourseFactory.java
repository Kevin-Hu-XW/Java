package design_pattern.工厂模式.工厂方法模式.案例;

public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
