package 网络编程.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    InetAddress类。该类的功能是代表一个IP地址，并且将IP地址和域名相关的操作方法包含在该类的内部。
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            //使用域名创建对象
            InetAddress inetAddress = InetAddress.getByName("www.huxiongwei.com");
            System.out.println(inetAddress);
            //使用IP创建对象
            inetAddress = InetAddress.getByName("39.105.9.163");
            System.out.println(inetAddress);
            //获得本机对象
            inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress);

            //获得对象中存储的域名和IP
            System.out.println("域名：" +inetAddress.getHostName()+"  IP: "+inetAddress.getHostAddress());

        }
        catch (UnknownHostException e){
            e.printStackTrace();
        }

    }
}
