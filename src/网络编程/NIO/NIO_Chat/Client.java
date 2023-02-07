package 网络编程.NIO.NIO_Chat;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
/*
    客户端实现
 */
public class Client {
    public static void main(String[] args) {
        try {
            //获取通道
            SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",10022));
            //切换为非阻塞模式
            schannel.configureBlocking(false);
            //分配指定缓冲区大小
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //发送数据给服务端
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.print("请说：");
                String msg = sc.nextLine();
                buffer.put(("kevin: "+msg).getBytes());
                buffer.flip();
                schannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
