package multithread.并发访问.volatile_KeyWord;

public class Test01 {
    public static void main(String[] args) {

        PrintString printString  = new PrintString();
        //调用打印字符串方法
        printString.printMethod();

        //main线程睡眠1000毫秒
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("在main 线程中修改打印标志");
        printString.setCountinuePrint(false);
        /*
            printString.printMethod();被调用后，程序一直处于死循环状态，
            无法执行到printString.setCountinuePrint(false);语句
            解决方法：多线程
         */
    }


    static class PrintString{
        private boolean countinuePrint = true;

        public PrintString setCountinuePrint(boolean countinuePrint){
            this.countinuePrint = countinuePrint;
            return this;
        }
        public void printMethod(){

            while (countinuePrint){
                System.out.println(Thread.currentThread().getName() );
            }
        }
    }
}
