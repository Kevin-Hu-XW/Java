package 网络编程.BIO.文件上传;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
    可以接收客户端上传的任意类型的文件，并保存到服务端磁盘
 */

public class Server {
    public static void main(String[] args) {
        try {
            //定义一个ServerSocket对象，进行服务端的端口注册
            ServerSocket ss = new ServerSocket(10022);

            while (true){
                // 交给一个独立的线程来处理与这个客户端的文件通信需求。
                Socket socket = ss.accept();
                System.out.println(new ServerReadThread(socket).getName());
                new ServerReadThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
