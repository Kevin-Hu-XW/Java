package 设计模式.七大软件架构设计原则.合成复用原则.修改后;

public abstract class DBConnection {
    //将具体Mysql实现抽离，当需要增加对其他数据库的支持，只需另外增加代码即可，不需要动源代码
    public abstract String getConnection();
}
