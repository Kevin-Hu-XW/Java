package 多线程.并发访问.intrinsiclock;


/**
 * 脏读
 * 出现读取属性值出现了一些意外, 读取的是中间值,而不是修改之后的值
 * 出现脏读的原因是对共享数据的修改与对共享数据的读取不同步
 * 解决方法:
 * 不仅对修改数据的代码块进行同步,还要对读取数据的代码块同步
*/
public class Test07 {
    public static void main(String[] args) {

        try {
            //开启子线程设置用户名和密码
            PublicValue publicValue = new PublicValue();
            SubThread subThread = new SubThread(publicValue);
            subThread.start();

            Thread.sleep(1000);
            //在main线程中获取用户名和密码
            publicValue.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class SubThread extends Thread {
        private PublicValue publicValue;
        public SubThread(PublicValue publicValue) {
            this.publicValue = publicValue;
        }

        @Override
        public void run() {
            super.run();
            publicValue.setValue("kevin","142327");
        }
    }
    static class PublicValue {
        private String name = "wkcto";
        private String pwd = "666";
        public  synchronized  void getValue() {
            System.out.println(Thread.currentThread().getName() + ",getter -- name: " + name + ",--pwd: " + pwd);
        }
        public  synchronized void setValue(String name, String pwd){
            this.name = name;
            try {
                Thread.sleep(1000); // 模拟操作name 属性需要一定时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pwd = pwd;
            System.out.println(Thread.currentThread().getName() + ",setter --name:" + name + ", --pwd: " + pwd );
        }
    }
}
