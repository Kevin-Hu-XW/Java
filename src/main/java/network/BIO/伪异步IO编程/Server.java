package network.BIO.伪异步IO编程;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
    开发实现伪异步通信架构
    思路：



 */

public class Server {
    public static void main(String[] args) {
        try {
            //定义一个ServerSocket对象，进行服务端的端口注册
            ServerSocket ss = new ServerSocket(10022);
            //创建线程池，负责不断接收客户端的请求
            HandlerSocketServerPool pool = new HandlerSocketServerPool(5,10);
            while (true){
                Socket socket = ss.accept();
                ServerThreadRead serverThreadRead = new ServerThreadRead(socket);
                pool.execute(serverThreadRead);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
