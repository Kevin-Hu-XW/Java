package 网络编程.BIO.多发和多收消息;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/*
    服务端可以反复的接收信息，客户端可以反复的发送消息
 */

public class Server {
    public static void main(String[] args) {
        try {
            //定义一个ServerSocket对象，进行服务端的端口注册
            ServerSocket ss = new ServerSocket(10022);
            //监听客户端的socket链接请求，此处只会接收一个客户端的请求，转而在获取字符输入流处，一直阻塞
            Socket socket = ss.accept();
            InputStream inputStream =socket.getInputStream();
            //把字节输入流包装成缓存字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg=bufferedReader.readLine())!=null){
                System.out.println("服务端收到："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
