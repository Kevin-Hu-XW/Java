package network.流;

import java.io.*;

/*  字节流OR字符流：
    如果是中文的话我们当然不能使用字节流而要使用字符流，但是如果你的文本内容
    是一些数字或者字母，这就可以使用我们的字节流啊

 */
public class IO_byteTest {
    public static void main(String[] args) {
        File file = new File("F:/a.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("a.txt is already exists!");
            //每次只读取一个字母，效率有点低
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                //read的返回值为-1，说明文件读取完毕，read每调用一次就会读取文本内容的下一个字节
                int i = fileInputStream.read();
                while (i > 0) {
                    //System.out.println((char) i);
                    i = fileInputStream.read();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //方法改进，以byte数组方式读取
            try {
                FileInputStream fileInputStream = new FileInputStream(file);

                byte[] bytes = new byte[1024];  //1kb
                //以一个kb的方式去读取，如果文本内容不超过一个kb的话就会全部读取，
                //将读取到的内容放在byte数组中并且返回文本内容的字节数
                String s = null;
                int read = fileInputStream.read(bytes);
                s = new String(bytes);
                //System.out.println(s);
                //System.out.println(read);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        //以byte数组写入
        try {

            byte[] bytes = {97, 98, 99, 100};  //1kb
            /*
                增加了一个true，什么意思呢？这里如果你不写的话默认就是false，
                那么你写入文本的时候就会覆盖之前的内容，但是如果你加上true的话就代表在原有文本之后追加
             */
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
