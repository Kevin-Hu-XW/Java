package 网络编程.BIO.文件上传;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ServerReadThread extends  Thread{
    private Socket socket;
    public ServerReadThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        InputStream inputStream = null;

        try {
            inputStream = socket.getInputStream();
            //把字节输入流包装成数据输入流
            DataInputStream dis = new DataInputStream(inputStream);
            //获取文件后缀名
            String suffix = dis.readUTF();
            System.out.println("服务端已经成功接收到了文件类型：" + suffix);
            //定义一个字节输管道，负责把客户端的文件数据写出去
            OutputStream os = new FileOutputStream("C:\\Users\\呼雄伟\\Desktop\\面试\\java\\IO\\文件\\server\\"+UUID.randomUUID().toString()
                    +"."+suffix);
            byte[] bytes = new byte[1024];
            int len;
            /*
                同步阻塞：客户端发送完数据后，服务端依然在等，又因为客户端代码，执行完毕，socket断开连接，
                会使服务端抛出Connection reset异常
                因此需要客户端发送一个数据发送完的标志，来告诉服务端数据已发送完毕，不需要在等待
                通过socket.shutdownOutput()来实现
             */
            while ((len=dis.read(bytes))>0){
                os.write(bytes,0,len);
            }
            os.flush();
            System.out.println("服务端接收文件保存成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
