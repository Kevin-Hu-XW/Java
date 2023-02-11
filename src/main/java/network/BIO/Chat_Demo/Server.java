package network.BIO.Chat_Demo;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/*
    目标：BIO模式下端口转发思想————服务端的实现
    服务端实现需求：
    1、注册端口
    2、接收客户端socket连接，交给一个独立的线程处理
    3、把当前连接的客户端socket连接存储到在线的socket结合中保存
    4、接收客户端的消息，然后推送给当前所有在线的socket接收
 */

public class Server {
    public static List<Socket> allSocketOnLine = new ArrayList<>();
    public static void main(String[] args) {
        try {
            //定义一个ServerSocket对象，进行服务端的端口注册
            ServerSocket ss = new ServerSocket(10022);
            while (true) {
                Socket socket = ss.accept();
                //登录客户端的socket存到一个集合中去
                allSocketOnLine.add(socket);
                //为客户端的socket，分配一个独立的线程
                new ServerReadThread(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
