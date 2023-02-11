package network.流;

import java.io.*;
/*
    FileInputStrem，它是一个字节流，读取的单位是byte
    InputStremReader，它是一个字符流，它所不同的就是传入的参数从byte变成char了，这就是两者的区别
 */
public class IO_CharacterTest {
    public static void main(String[] args) {
        File file = new File("F:/b.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("file is exists!");
        }
        //写入字符流
        String str =null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,true);
            str = "貌似欧迪芬三农法搜地方";
            fileWriter.write(str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                fileWriter.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }


        //读取字符流
        try (FileInputStream fs = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fs,"UTF-8");
             FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){

            System.out.println("InputStreamReader***************");
            //InputStreamReader获取字符输入流，需要传入一个字节流和编码格式

            char[] chars =  new char[20*1024];
            //read方法把读取到的字符放入chars中，返回int型的整数为读取了多少个字符
            int read = inputStreamReader.read(chars);
            System.out.println(String.valueOf(chars));
            System.out.println(read);


            System.out.println("FileReader*********************");
            //FileReader不需要传字节流和编码格式，直接传文件即可

            read = fileReader.read(chars);
            System.out.println(String.valueOf(chars));
            System.out.println(read);

            System.out.println("BufferedReader******************");
            /*
             BufferedReader我们叫做缓冲流，当然是对Reader做缓冲的，
             BufferedReader读取文本内容可以保证文本内容的格式不被打乱
             BufferedReader需要接收一个字符流 InputStreamReader，
             然后就可以直接调取readLine方法进行整行读取，
             会得到一个字符串，可以直接输出，因为是整行读取可以保持格式不乱
            */

            String line = null;
            while ((line=bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
