package network.tcp;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/*
 * java.net.Socket
 * 封装了tcp协议的通讯细节，使得我们使用它就可以完成与远程计算机tcp连接以及数据
 * 传输并且，完成数据传输是基于两条流的读写进行
 */
public class Client {
    private Socket socket;
    /*
     * 构造方法，用于初始化客户端
     */
    public Client(){
        try {
            /*
             * socket实例化时需要指定两个参数：
             * 1.服务端的地址信息（IP）
             * 2.服务端应用程序绑定的端口
             * socket实例化的过程就是连接服务端的过程，成功连接则实例化成功，否则实例化过程抛出异常
             * 我们通过IP地址找到网络是那个的服务端所在计算机，通过端口找到该机器上的服务端应用程序
             */
            System.out.println("正在连接服务器.......");
            socket = new Socket("127.0.0.1",10022);
            System.out.println("服务器成功连接.......");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    //客户端开始工作
    public void start(){
        OutputStream outputStream = null;
        OutputStreamWriter ow = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            /*
             * OutputStream getOutputStream 通过socket获取字节输出流写出的字节
             * 可以通过网络发送给远端计算机
             */
            outputStream = socket.getOutputStream();
            ow =new OutputStreamWriter(outputStream,"utf-8");
            bw =new BufferedWriter(ow);
            pw = new PrintWriter(bw);
            Scanner scanner =  new Scanner(System.in);
            while (true) {
                pw.flush();
                String s = scanner.nextLine();
                pw.println(s);
                System.out.println("发送完毕....");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pw.close();
                bw.close();
                ow.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
