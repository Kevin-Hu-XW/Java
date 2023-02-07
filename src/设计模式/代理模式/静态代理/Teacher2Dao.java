package 设计模式.代理模式.静态代理;

public class Teacher2Dao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师2上课了");
    }
}
