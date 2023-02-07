package 设计模式.代理模式.Cglib代理;


//public class ProxyFactory implements MethodInterceptor {

//    //维护一个目标对象
//    private Object target;
//
//    public ProxyFactory(Object target){
//        this.target = target;
//    }
//    //返回一个代理对象:是target对象的代理对象
//    public Object getProxyInstance(){
//        //1、创建一个工具类
//        Enhancer enhancer = new Enhancer();
//        //2、设置父类
//        enhancer.setSuperclass(target.getClass());
//        //3、设置回调函数
//        enhancer.setCallback(this);
//        //4、创建子类对象，即动态代理对象
//        return enhancer.create();
//    }
//
//    //重写intercept 方法，会调用目标对象的方法
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println("Cglib代理开始");
//        Object returnVal = method.invoke(target, objects);
//        System.out.println("Cglib代理结束");
//        return returnVal;
//    }
//}
