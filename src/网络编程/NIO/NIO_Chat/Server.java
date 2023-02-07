package 网络编程.NIO.NIO_Chat;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
/*
    NIO非阻塞通信，服务端开发
 */
public class Server {
    //定义成员变量属性；选择器，服务端通道，端口
    private Selector selector;
    private ServerSocketChannel ssChannel;
    private static final int port = 10022;
    //初始化
    public Server(){
        try {
            //获取通道
            ssChannel = ServerSocketChannel.open();
            //切换为非阻塞模式
            ssChannel.configureBlocking(false);
            //绑定连接的端口
            ssChannel.bind(new InetSocketAddress(port));
            //获取选择器Selector
            selector = Selector.open();
            //将通道注册到选择器上，并且开始指定接收监听客户端连接事件
            ssChannel.register(selector,SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void listen() {
        System.out.println("监听线程"+Thread.currentThread().getName());
        try {
            while (selector.select()>0){
                //获取选择器中所有注册的通道已经就绪好的事件
                //selector.selectedKeys()返回关注事件的集合
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //开始遍历这些准备好的事件
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    //判断这个事件是什么,并根据不同的事件做相应的处理
                    if (selectionKey.isAcceptable()){    //通过服务端注册的通道来监听客户端的连接事件
                        //直接获取当前接入客户端的通道，用于数据通信
                        SocketChannel schannel = ssChannel.accept();
                        //设置为非阻塞模式
                        schannel.configureBlocking(false);
                        //将socketchannel注册到selector，关注事件为op_read,同时给socketchannel关联一个buffer
                        schannel.register(selector,SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                        System.out.println("连接");
                    }
                    if (selectionKey.isReadable()){
                        //获取当前选择器上的读就绪事件，反向的方式获取
                        ////通过selectedKey反向获取通道
                        SocketChannel schannel = (SocketChannel)selectionKey.channel();
                        //获取到关联的buffer
                        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        int len=0;
                        while ((len=schannel.read(buffer))>0){
                            buffer.flip(); //数据归位，设置为可读模式
                            System.out.println(new String(buffer.array(),0,len));
                            buffer.clear();  //清除缓冲区数据
                        }
                    }
                    //处理完毕后要移除当前sslectionKey,防止重复操作
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("----------服务端启动----------");
        Server server = new Server();
        //监听客户端的各种消息，连接，读写
        server.listen();
    }
}
