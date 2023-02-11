package network.tcp;
/*
 * java.net.ServerSocket
 * 运行在服务端的ServerSocket
 * 主要有两个工作：
 * 1.向系统申请服务端端口，客户端就是通过这个端口与服务端建立连接的
 * 2.监听该端口，这样一旦一个客户端进行连接时，serverSocket会自动创建一个
 * socket通过这个socket就可以与该客户端交互了
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    private ServerSocket serverSocket;
    public Server(){
        try {
            /*
             * 实例化ServerSocket的同时需要向系统申请服务端口，客户端
             * 就是通过这个端口与服务端建立连接的，如果该端口被系统的其他程序占用，会抛出异常
             */
            System.out.println("服务端正在启动........");
            serverSocket = new ServerSocket(10023);
            System.out.println("服务端启动完毕");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        InputStream inputStream = null;
        InputStreamReader ir = null;
        BufferedReader br = null;
        try {
            /*
             * Socket accept()
             * 该方法是一个阻塞方法，调用后服务端开始等待客户端连接，直到
             * 一个客户端连接为止，并且此时会返回一个socket实例，使用这个实例
             * 即可与客户端进行交互
             * 多次调用该方法可以接受多个客户端的连接
             */
            System.out.println("等待客户端连接.......");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了");
            /*
             * InputStream getInputStream()
             * 通过socket获取的输入流可以读取远端计算机发送来的字节
             */
            inputStream = socket.getInputStream();
            ir =new InputStreamReader(inputStream,"utf-8");
            br = new BufferedReader(ir);
            while (true) {

                String s = br.readLine();
                System.out.println("客户端说："+s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                br.close();
                ir.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
