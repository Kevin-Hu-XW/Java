package 多线程.并发访问.volatile_KeyWord;

public class Test02 {
    public static void main(String[] args) {

        PrintString printString  = new PrintString();
        //开启子线程执行printMethod()
        new Thread(new Runnable() {
            @Override
            public void run() {
                printString.printMethod();
            }
        }).start();
        //main线程睡眠1000毫秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("在main线程中修改打印标志:"+Thread.currentThread().getName());
        printString.setCountinuePrint(false);
        //程序运行,查看在main 线程中修改了打印标志之后,子线程打印是否可以结束打印
        //程序运行后, 可能会出现死循环情况
        //分析原因: main 线程修改了printString 对象的打印标志后, 子线程读不到
        //解决办法: 使用volatile 关键字修饰printString 对象的打印标志.
        // volatile 的作用可以强制线程从公共内存中读取变量的值,而不是从工作内存中读取
    }


    static class PrintString{
        private volatile boolean countinuePrint = true;

        public PrintString setCountinuePrint(boolean countinuePrint){
            this.countinuePrint = countinuePrint;
            return this;
        }
        public void printMethod(){
            System.out.println(Thread.currentThread().getName()+"开始了....");
            while (countinuePrint){
                System.out.println(1);
            }
            System.out.println(Thread.currentThread().getName()+"结束了....");
        }
    }
}
