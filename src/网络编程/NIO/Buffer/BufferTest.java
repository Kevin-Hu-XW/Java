package 网络编程.NIO.Buffer;

import org.junit.Test;
import java.nio.ByteBuffer;
/*
 * 1.写入数据到Buffer
 * 2.调用flip()方法，转换为读取模式
 * 3.从Buffer中读取数据
 * 4.调用buffer.clear()方法或者buffer.compact()方法清除缓冲区
 */
public class BufferTest {
    @Test
    public void test01(){
        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-----------------------");
        //put往缓冲区添加数据
        String str = "kevin";
        buffer.put(str.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-----------------------");

        //flip() 将缓冲区的大小设置为当前位置，并将当前位置设置为0  可读模式
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-----------------------");

        //get数据的读取
        char c = (char) buffer.get();
        System.out.println(c);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println();
        System.out.println("-----------------------");
    }
    @Test
    public void test02(){
        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-----------------------");
        //put往缓冲区添加数据
        String str1 = "kevin1";
        buffer.put(str1.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-----------------------");

        //clear() 将缓冲区数据清除并没有将数据真的清除，
        // 而是将索引的位置定位到初始位置，通过在次的存入数据进行覆盖，二达到清除的效果
        buffer.clear();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println((char) buffer.get());
        System.out.println("-----------------------");
    }
    @Test
    public void test03(){
        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        //put往缓冲区添加数据
        String str = "james";
        buffer.put(str.getBytes());
        buffer.flip();

        byte[] b2 = new byte[2];
        buffer.get(b2);
        String rs = new String(b2);
        System.out.println(rs);

        buffer.mark();  //标记刺客位置 2
        System.out.println("-----------------------");
        byte[] b3 = new byte[3];
        buffer.get(b3);
        rs = new String(b3);
        System.out.println(rs);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        buffer.reset();  //回到标记位置
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        if (buffer.hasRemaining()){
            System.out.println(buffer.remaining());
        }
    }

}
