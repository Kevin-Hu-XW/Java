package 网络编程.流.序列化;

import java.io.Serializable;

/*
    一、Java序列化与反序列化三连问:是什么？为什么要？如何做？
    序列化：序列化是把对象转换成有序字节流，以便在网络上传输或者保存在本地文件中。核心作用是对象状态的保存与重建。
    反序列化：客户端从文件中或网络上获得序列化后的对象字节流，根据字节流中所保存的对象状态及描述信息，通过反序列化重建对象。

    二、为什么需要序列化与反序列化？
    1.利用序列化实现远程通信，即：能够在网络上进行传递和接收。
    2.通过序列化在进程间传递对象；
    3.实现了数据的持久化，通过序列化可以把数据永久地保存到硬盘上（如：存储在文件里），实现永久保存对象。

    三、使用场景：
    1.当你想把的内存中的对象状态保存到一个文件中或者数据库中时候。
    2.当你想用套接字在网络上传送对象的时候。
    3.当你想通过RMI传输对象的时候。
 */
public class Person implements Serializable  {  //本类可以序列化
    public String name;
    public int age;
    Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public String toString(){
       return this.name+" "+this.age;
    }
}
