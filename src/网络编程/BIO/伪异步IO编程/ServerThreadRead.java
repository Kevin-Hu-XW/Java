package 网络编程.BIO.伪异步IO编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
/*
 * 1.伪异步io采用了线程池实现，因此避免了为每个请求创建一个独立线程造成线程资源耗尽的问题，
 *   但由于底层依然是采用的同步阻塞模型，因此无法从根本上解决问题。
 * 2.如果单个消息处理的缓慢，或者服务器线程池中的全部线程都被阻塞，
 *   那么后续socket的i/o消息都将在队列中排队。新的Socket请求将被拒绝，客户端会发生大量连接超时。


 */
public class ServerThreadRead implements Runnable {
    private Socket socket;
    public ServerThreadRead(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg=br.readLine())!=null){
                System.out.println("服务端收到："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
