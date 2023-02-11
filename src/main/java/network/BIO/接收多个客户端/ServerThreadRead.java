package network.BIO.接收多个客户端;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadRead extends Thread  {
    private Socket socket;
    public ServerThreadRead(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
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
