package JVM;


public class Test_Native {
    public static void main(String[] args) {

        new Thread(()->{

        },"my thread name").start();

    }
    /*
        native:凡是带了native关键字的，说明java的作用范围达不到了，需要回去调底层C语言的库
        会进入本地方法栈，调用本地方法接口，JIN(Java Native Interface)
        JIN的作用：扩展java的使用，融合不同的语言为java使用
        背景：最初java诞生的时候，C、C++横行，java要想立足，必须要有调用C、C++ 的程序
              它在内存区域开辟了一块标记区域：Native Method Stack，用来登记native方法，
              在最终执行的时候，加载本地方法库中的方法通过JNI
     */
    private native void start0();
}
