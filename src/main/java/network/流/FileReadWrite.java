package network.流;

import java.io.*;

/*
    不管是磁盘还是网络传输，最小的存储单元都是字节，而不是字符，所以 I/O 操作的都是字节而不是字符
    编码就是把字符转换为字节，而解码是把字节重新组合成字符。
    byte[] bytes = str.getBytes(encoding);   //编码     字符->字节
    String str =new String(bytes, encoding);  //解码     字节->字符

    结论：只要是处理纯文本数据，就优先考虑使用字符流。除此之外都使用字节流。
 */
public class FileReadWrite {
    public static void main(String[] args) {
        File file = new File("F:/c.txt");

            try {
                if (!file.exists()){
                    file.createNewFile();
                }
                InputStreamReader fileInputStream = new InputStreamReader(System.in);
                BufferedReader ir = new BufferedReader(fileInputStream);
                OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file));
                String temp = null;
                while (!ir.readLine().equals("-1")) {
                    temp = new String(ir.readLine());
                    ow.write(temp);
                    ow.flush();

                }
                ir.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes =new byte[200];
                int len = 0;
                while ((len = fileInputStream.read(bytes))>0) {
                    System.out.println(new String(bytes,"utf-8"));
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
    }
}
