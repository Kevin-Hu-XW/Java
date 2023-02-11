package multithread.线程通信.ThreadLocal;
/*
    需求：线程隔离
          在多并发场景下，每个线程中的变量都是相互独立的
          线程A：设置（变量1）   获取（变量1）
          线程B：设置（变量2）   获取（变量2）
          ThreadLocal：
                                                                                                                                                                                                                                                                                                                                                   2.get():获取当前线程绑定的变量
 */
public class MyDemo1 {
    public String content;
    ThreadLocal<String> t1 = new ThreadLocal<>();
    public void setContent(String content){
        //this.content = content;
        //变量与当前线程绑定
        t1.set(content);
    }
    public String getContent(){
        String s= t1.get();
        return s;
    }

    public static void main(String[] args) {
        MyDemo1 myDemo1 = new MyDemo1();
        for (int i=0;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myDemo1.setContent(Thread.currentThread().getName()+"的数据");
                    System.out.println(Thread.currentThread().getName()+"------>"+myDemo1.getContent());
                }
            }).start();
        }
    }
}
