package network.BIO.文件上传;

import java.io.*;
import java.net.Socket;

/*
     实现客户端上传任意类型的文件个服务端

     总结：客户端怎么发，服务端怎么收，客户端要与服务端一一对应
 */
public class Client {
    public static void main(String[] args) {
        try {
            //创建socket对象，请求服务端的链接
            Socket socket = new Socket("127.0.0.1",10022);
            //传入文件地址
            String path = "C:\\Users\\呼雄伟\\Desktop\\面试\\java\\IO\\文件\\data.txt";
            InputStream is = new FileInputStream(path);
            //从socket中获得字节输出流,并把字节输出流包装成数据输出流
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //先发送上传文件的后缀给服务端
            dos.writeUTF(path.split("\\.")[1]);
            //把文件数据发送给服务端进行接收,通过用byte数组进行传输
            byte[] bytes = new byte[1024];
            int len=0;
            while ((len=is.read(bytes))>0){
                dos.write(bytes,0,len);
            }
            dos.flush();
            //通知服务端数据发生完毕
            socket.shutdownOutput();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
