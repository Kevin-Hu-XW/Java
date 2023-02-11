package network.BIO.接收多个客户端;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
    服务端可以接收多个客户端Socket通信请求
    思路：服务端每接收到一个请求对象后都交给一个独立的线程来处理数据交互需求


    总结：
    * 1.每个Socket接收到，都会创建一个线程，线程的竞争、切换上下文影响性能；
    * 2.每个线程都会占用栈空间和CPU资源；
    * 3.并不是每个socket都进行IO操作，无意义的线程处理；
    * 4.客户端的并发访问增加时。服务端将呈现1:1的线程开销，访问量越大，
    * 系统将发生线程栈溢出，线程创建失败，最终导致进程宕机或者僵死，从而不能对外提供服务。
 */

public class Server {
    public static void main(String[] args) {
        try {
            //定义一个ServerSocket对象，进行服务端的端口注册
            ServerSocket ss = new ServerSocket(10022);
            //定义一个死循环，负责不断接收客户端的请求
            while (true) {
                Socket socket = ss.accept();
                new ServerThreadRead(socket).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
