package design_pattern.代理模式.Cglib代理;

public class Client {
    public static void main(String[] args) {

        //创建目标对象
        TeacherDao target = new TeacherDao();

        //获取代理对象
        //TeacherDao proxy = (TeacherDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象方法，会触发Intercept方法，从而实现对目标对象的调用
        //proxy.teach();
    }
}
