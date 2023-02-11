package design_pattern.代理模式.静态代理;


/*
    静态代理对象
 */
public class TeacherDaoProxy implements ITeacherDao{

    private ITeacherDao target;   //目标对象通过接口来聚合

    public TeacherDaoProxy(ITeacherDao target){
        this.target = target;
    }
    @Override
    public void teach() {
        System.out.println("代理开始。。。");  //给目标对象添加功能
        target.teach();
        System.out.println("代理结束。。。");
    }

}
