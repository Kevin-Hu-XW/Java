package 基础.异常;


public class MyException extends Exception {
    private String  message;
    public MyException(String message){
        //出现异常打印的语句
        super(message);
        this.message = message;
    }
}
class UseMyException{
    private String usename;
    private String password;
    public UseMyException(String usename,String password){
        this.usename = usename;
        this.password = password;
    }
    public void throwMyException(String password) throws MyException {
        if (!this.password.equals(password)){
            throw new MyException("用户密码错误！");
        }
    }

    public static void main(String[] args) {
        UseMyException ex = new UseMyException("admin","123");
        try {
            ex.throwMyException("1234");
        } catch (MyException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } finally {
            System.out.println("finally总是执行！");
        }
    }
}
