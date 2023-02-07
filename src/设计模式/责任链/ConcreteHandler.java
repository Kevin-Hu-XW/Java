package 设计模式.责任链;
/*
    具体的处理者：具体处理者街都请求后，可以处理选择处理，也可以将请求传递给下一个处理者
 */
public class ConcreteHandler extends Handler {
    //调用次方法处理请求
    @Override
    public void handlerRequest() {
        /**
         * 判断是否有后继的责任对象
         * 如果有，就转发请求给后继的责任对象
         * 如果没有，则处理请求
         */
        if (getSuccessor()!=null){
            System.out.println("放过请求,请求下一个对象处理");
            getSuccessor().handlerRequest();
        }
        else
            System.out.println("处理请求");
    }
}
