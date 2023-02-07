package 网络编程.流;

import javax.sound.sampled.Line;
import java.io.*;

/*
    1、流具有方向性，至于是输入流还是输出流则是一个相对的概念，
       一般以程序为参考，如果数据的流向是程序至设备，我们成为输出流，反之我们称为输入流
    流有哪些分类：1、处理的数据单位不同，可分为：字符流，字节流
                 2、数据流方向不同，可分为：输入流，输出流
                 3、功能不同，可分为：节点流，处理流
    节点流：节点流从一个特定的数据源读写数据。即节点流是直接操作文件，网络等的流，
            例如FileInputStream和FileOutputStream，他们直接从文件中读取或往文件中写入字节流。
    处理流：“连接”在已存在的流（节点流或处理流）之上通过对数据的处理为程序提供更为强大的读写功能。


 */
public class WriteAndReadFile {
    public static void main(String[] args) {
        try {
            //节点流FileOutputStream直接以A.txt作为数据源操作
            FileOutputStream fileOutputStream = new FileOutputStream("A.txt");
            //过滤流BufferedOutputStream进一步装饰节点流，提供缓存写
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //过滤流dataOutputStream进一步装饰过滤流bufferedOutputStream，提供基本数据类型的写
            DataOutputStream out = new DataOutputStream(bufferedOutputStream);
            out.write(1);
            out.write(new byte[]{1,2,3});
            out.writeBoolean(false);
            out.writeChars("kevin");
            out.flush();
            out.close();



        }
        catch (IOException e){
            System.out.println("file is not found!");
        }
        finally{

        }


    }
}
