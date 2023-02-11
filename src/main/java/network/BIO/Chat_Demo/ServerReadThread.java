package network.BIO.Chat_Demo;

import java.io.*;
import java.net.Socket;

public class ServerReadThread extends  Thread{
    private Socket socket;
    public ServerReadThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //从socket中获取客户端的输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg=br.readLine())!=null){   //当客户端下线后，这里就会抛出异常
                sendMsgToAllClient(msg);
            }
        } catch (IOException e) {
            System.out.println("当前有人下线了");
            //在线socket集合中移除socket
            Server.allSocketOnLine.remove(socket);
        }
    }
    /*
        把当前客户端的消息推送给全部的在线socket
     */
    public void sendMsgToAllClient(String msg) throws IOException {
        for(Socket socket:Server.allSocketOnLine){
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.print(msg);
            ps.flush();
        }
    }
}
