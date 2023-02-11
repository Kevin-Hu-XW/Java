package network.tcp;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer {
    public ServerSocket serverSocket;
    public SimpleServer(){
        try {
            System.out.println("服务端正在启动........");
            serverSocket = new ServerSocket(10023);
            System.out.println("服务端启动完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        InputStream is = null;
        BufferedInputStream bi =null;
        OutputStream os = null;
        BufferedOutputStream bo = null;
        Socket socket = null;
        int n=0;
        byte[] bytes = new byte[1024];
        try {
            socket = serverSocket.accept();
            is = socket.getInputStream();
            bi = new BufferedInputStream(is);
            os = socket.getOutputStream();
            bo = new BufferedOutputStream(os);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                n=bi.read(bytes);
                System.out.println("客户端说："+new String(bytes,0,n));
                String s = scanner.nextLine();
                bo.write(s.getBytes());
                bo.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bi.close();
                bo.close();
                os.close();
                is.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        SimpleServer simpleServer = new SimpleServer();
        simpleServer.start();
    }
}
