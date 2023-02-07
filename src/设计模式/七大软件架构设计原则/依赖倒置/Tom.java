package 设计模式.七大软件架构设计原则.依赖倒置;

public class Tom {

    private ICourse course;

    /*
        注入方式 1、构造器注入   2、Setter方式注入
        构造器注入，调用时每次都会创建实例
        Setter方式注入，当Tom是全局单例时可以使用
     */
//    public Tom(ICourse course) {
//        this.course = course;
//    }

    public void setCourse(ICourse course){
        this.course = course;
    }

    public void study(){
        course.study();
    }
}
