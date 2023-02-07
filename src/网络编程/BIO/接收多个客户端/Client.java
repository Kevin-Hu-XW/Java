package 网络编程.BIO.接收多个客户端;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            //创建socket对象，请求服务端的链接
            Socket socket = new Socket("127.0.0.1",10022);
            //从socket中获得字节输出流
            OutputStream os = socket.getOutputStream();
            //把直接输出流包装成打印流
            PrintWriter pw = new PrintWriter(os) ;
            Scanner scanner = new Scanner(System.in) ;
            while (true){
                System.out.print("请说：");
                String msg = scanner.nextLine();
                pw.println(msg);
                pw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
