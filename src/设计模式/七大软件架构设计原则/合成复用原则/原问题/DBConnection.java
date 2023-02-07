package 设计模式.七大软件架构设计原则.合成复用原则.原问题;

public class DBConnection {
    //问题如果要连接Oracle数据库需要修改源代码，违反开闭原则
    public String getConnection() {
        return "Mysql数据库连接！";
    }
}
