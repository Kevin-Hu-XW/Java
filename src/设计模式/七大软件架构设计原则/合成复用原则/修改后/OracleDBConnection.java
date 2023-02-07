package 设计模式.七大软件架构设计原则.合成复用原则.修改后;

public class OracleDBConnection extends DBConnection{
    @Override
    public String getConnection() {
        return "Oracle数据库连接！";
    }
}
