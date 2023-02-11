package network.流;

import java.io.File;
import java.io.IOException;
/*
    文本文件应该就是那些内容是纯文本的吧，比如txt文件或者我们写的Java文件
    二进制文件就是我们平常见到的图片，音视频等

    字节流:
    对于字节流，它是用来操作我们的二进制文件的，为什么呢？因为字节流可以操作的数据是8位，
    也就是一字节，我们知道1 byte = 8bit，而像一些数字和字母等都是占一个字节，这就可以使用字节流来操作，
    但是对于中文的话就不能使用字节流了

    字符流:
    因为一个汉字是占两个字节，那么就是16位，字节流是操作不了的，
    而字符流则可以操作16位，所以对于文本文件则常用字符流操作了


    注意：字节流可以用来处理纯文本文件，但是字符流不能用于处理图像视频等非文本类型的文件
*/
public class FileTest {
    public static void main(String[] args) {
        //创建文件
        File file = new File("F:/a.txt");
        try {
            /*
                果本地已经有文件的话，这个方法就不会再创建新文件了，
                也就是只有当文件不存在才会创建一个新的文件，
             */
            file.createNewFile();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        /*创建文件夹
          但java.io.File.mkdir()只能创建一级目录且父目录必须存在，否则将无法正确创建一个目录；
          java.io.File.mkdirs()可以创建多级目录，父目录不一定存在。
         */
        File file1 = new File("F:/a/a");
        if (!file1.exists()){
            file1.mkdirs();
        }
        else
            System.out.println(file1.toString()+" is exists");
    }
}
