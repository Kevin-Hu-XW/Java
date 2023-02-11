package network.tcp;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    private Socket socket;
    public SimpleClient(){

        try {
            System.out.println("正在连接服务器.......");
            socket = new Socket("127.0.0.1",10023);
            System.out.println("服务器成功连接.......");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //客户端开始工作
    public void start(){
        OutputStream os = null;
        BufferedOutputStream bs=null;
        InputStream is = null;
        BufferedInputStream bi = null;
        byte[] bytes = new byte[1024];
        try {
            os = socket.getOutputStream();
            bs = new BufferedOutputStream(os);
            is =socket.getInputStream();
            bi = new BufferedInputStream(is);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String s = scanner.nextLine();
                /*  向服务端发送数据
                字符串转换为二进制编码，通过字节流传输
             */
            /*
                数据是写在缓冲当中的，并没有通过网络发送出去，要等到这个缓冲满的时候，那么这个数据才会发送出去
                所以要通过bs.flush();对缓冲流中的数据进行强制输出
             */
                bs.write(s.getBytes());
                bs.flush();
                System.out.println("发送完毕....");
            /*
                接受数据
             */

                int n=bi.read(bytes);
                System.out.println("服务器说："+new String(bytes,0,n));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bi.close();
                bs.close();
                is.close();
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        client.start();
    }
}
