package design_pattern.责任链;
/*
    抽象处理者：定义一个请求处理的接口，可以定义出一个方法设定和返回对下家的引用
    1、责任链对象
    2、抽象的处理请求的方法
    3、获得下一个处理请求的对象的方法
    4、设置下一个处理请求对象的方法
 */
public  abstract class Handler {
    //持有后继的责任链对象
    protected Handler successor;

    //示意处理请求的方法
    public abstract void handlerRequest();
    //取值方法，获得对下家的引用
    public Handler getSuccessor(){
        return successor;
    }

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }
}
