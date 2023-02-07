package 网络编程.BIO.传统BIO实例;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 在以上通信中，服务端会一致等待客户端的消息，如果客户端没有进行消息的发送，服务端将一直进入阻塞状态。
 * 同时服务端是按照行获取消息的，这意味着客户端也必须按照行进行消息的发送，否则服务端将进入等待消息的阻塞状态
 */
public class Server {
    public static void main(String[] args) {
        try {
            //定义一个ServerSocket对象，进行服务端的端口注册
            ServerSocket ss = new ServerSocket(10022);
            //监听客户端的socket链接请求
            Socket socket = ss.accept();
            InputStream inputStream =socket.getInputStream();
            //把字节输入流包装成缓存字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            //while ((msg=bufferedReader.readLine())!=null){
            /*
            只读取一行，若使用while，读取一行后，会进入阻塞状态，一直等待客户端发消息，但客户端socket已经结束，
            服务端的socket抛出Connection reset异常
            任何一方的socket挂机，对方的socket都会出现异常机制
             */
            if ((msg=bufferedReader.readLine())!=null){
                System.out.println("服务端说："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
