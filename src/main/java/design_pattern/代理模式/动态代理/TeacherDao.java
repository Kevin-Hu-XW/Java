package design_pattern.代理模式.动态代理;

public class TeacherDao implements ITeacherDao {


    @Override
    public void teach() {
        System.out.println("老师授课。。。");
    }

    @Override
    public void sing() {
        System.out.println("sing.....");
    }
}
