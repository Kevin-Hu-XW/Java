package design_pattern.七大软件架构设计原则.合成复用原则.修改后;

public class MysqlConnection extends DBConnection{
    @Override
    public String getConnection() {
        return "Mysql数据库连接！";
    }
}
