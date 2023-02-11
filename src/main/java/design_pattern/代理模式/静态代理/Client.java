package design_pattern.代理模式.静态代理;

public class Client {
    public static void main(String[] args) {


        //目标对象(被代理对象)
        //ITeacherDao target = new TeacherDao();
        ITeacherDao teacher2Dao = new Teacher2Dao();
        //代理对象,同时将被代理对象传递给代理对象
        TeacherDaoProxy proxy = new TeacherDaoProxy(teacher2Dao);
        //通过代理对象，执行被代理对象的方法
        //执行的是代理对象的方法，代理对象再去调用目标对象的方法
        proxy.teach();
    }
}
