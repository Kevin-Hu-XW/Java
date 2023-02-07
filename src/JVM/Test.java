package JVM;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        System.out.println("-Xmx:"+Runtime.getRuntime().maxMemory()/1024/1024);
//        System.out.println("-Xms:"+Runtime.getRuntime().totalMemory()/1024/1024);
        String data = "www.baidu.com";
        while (true){
            data +=data+new Random().nextInt(88888)+new Random().nextInt(999999);
            System.out.println(data);
            //java.lang.OutOfMemoryError: Java heap space
        }
    }
}
