package 网络编程.NIO.Channel;

import org.junit.jupiter.api.Test;;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {
    @Test
    //写数据到本地文件
    public void test1(){
        try {
            //直接输出流，通向目标文件
            FileOutputStream fos = new FileOutputStream("data.txt");
            //得到直接输出流对应的通道
            FileChannel fc = fos.getChannel();
            //分配缓存区
            ByteBuffer buffer =  ByteBuffer.allocate(1024);
            buffer.put("hello World！".getBytes());
            //把缓冲区切换成读模式
            buffer.flip();
            fc.write(buffer);
            fc.close();
            System.out.println("写数据到文件中！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    //从本地文件读数据到控制台
    public void test2(){
        try {
            FileInputStream fis = new FileInputStream("data.txt") ;
            FileChannel channel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 4、读取数据到缓冲区
            channel.read(buffer);
            buffer.flip();
            //从缓冲区读出数据即可
            String res = new String(buffer.array(),0,buffer.remaining());
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void copy(){
        try {
            FileInputStream is = new FileInputStream("C:\\Users\\呼雄伟\\Desktop\\面试\\java\\IO\\文件\\壁纸.jpg");
            FileOutputStream os = new FileOutputStream("C:\\Users\\呼雄伟\\Desktop\\面试\\java\\IO\\文件\\new.jpg");
            //得到文件通道
            FileChannel ischannel = is.getChannel();
            FileChannel oschannel = os.getChannel();
            //分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                //必须清空缓存，再写数据到缓存区
                buffer.clear();
                //开始读数据
                int flag  = ischannel.read(buffer);
                if (flag==-1)
                    break;
                //把数据切换到可读模式
                buffer.flip();
                //把数据写出
                oschannel.write(buffer);
            }
            ischannel.close();
            oschannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
        分散读取（Scatter ）:是指把Channel通道的数据读入到多个缓冲区中去

        聚集写入（Gathering ）是指将多个 Buffer 中的数据“聚集”到 Channel。
     */
    @Test
    public void test3(){
        try {
            FileInputStream is =  new FileInputStream("data.txt");
            FileOutputStream os = new FileOutputStream("data1.txt");
            //申请两个缓冲区，，进行分散保存数据
            ByteBuffer buffer1 = ByteBuffer.allocate(2);
            ByteBuffer buffer2 = ByteBuffer.allocate(1024);
            ByteBuffer[] buffers = {buffer1,buffer2};
            //得到文件通道
            FileChannel ischannel = is.getChannel();
            FileChannel oschannel = os.getChannel();
            //分散读取数据
            ischannel.read(buffers);
            for (ByteBuffer buffer:buffers){
                //把数据设置为可读模式
                buffer.flip();
            }

            //聚集写入
            oschannel.write(buffers);
            ischannel.close();
            oschannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
        transferFrom
     */
    @Test
    public void test02() throws Exception {
        // 1、字节输入管道
        FileInputStream is = new FileInputStream("data1.txt");
        FileChannel isChannel = is.getChannel();
        // 2、字节输出流管道
        FileOutputStream fos = new FileOutputStream("data03.txt");
        FileChannel osChannel = fos.getChannel();
        // 3、复制
        osChannel.transferFrom(isChannel,isChannel.position(),isChannel.size());
        isChannel.close();
        osChannel.close();
    }
    /*
        transferTo
     */
    @Test
    public void test03() throws Exception {
        // 1、字节输入管道
        FileInputStream is = new FileInputStream("data1.txt");
        FileChannel isChannel = is.getChannel();
        // 2、字节输出流管道
        FileOutputStream fos = new FileOutputStream("data04.txt");
        FileChannel osChannel = fos.getChannel();
        // 3、复制
        isChannel.transferTo(isChannel.position() , isChannel.size() , osChannel);
        isChannel.close();
        osChannel.close();
    }
}
