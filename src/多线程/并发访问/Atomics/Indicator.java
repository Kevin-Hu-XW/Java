package 多线程.并发访问.Atomics;

import java.util.concurrent.atomic.AtomicLong;

/*
  使用原子变量类定义一个计数器
  该计数器,在整个程序中都能使用,并且所有的地方都使用这一个计数器,这个计数器可以设计为单例
 */
public class Indicator {
    //构造方法私有化
    private Indicator(){}
    //定义一个私有本类静态对象
    private static final Indicator instace = new Indicator();
    //提供一个静态返回方法，返回该类的唯一实例
    public static Indicator getInstace(){
        return instace ;
    }

    //使用原子类保存请求总数,成功数,失败数
    private final AtomicLong requestCount = new AtomicLong(0);
    private final AtomicLong successCount = new AtomicLong(0);
    private final AtomicLong fialureCount = new AtomicLong(0);


    //有新的请求
    public void newRequest() {
        requestCount.getAndIncrement();
    }
    //处理成功
    public void requestProcessSuccess() {
        successCount.getAndIncrement() ;
    }
    //处理失败
    public void requestProcessFailure() {
        fialureCount.getAndIncrement();
    }

    //查看总数，成功数，失败数
    public Long getRequestCount() {
        return requestCount.get();
    }

    public Long getsuccessCount() {
        return successCount.get();
    }
    public Long getfialureCount() {
        return fialureCount.get();
    }
}
