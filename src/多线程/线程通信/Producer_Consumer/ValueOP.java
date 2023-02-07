package 多线程.线程通信.Producer_Consumer;


public class ValueOP {
    private String value = "";
    public void setValue(){
        synchronized (this){
            //while (!this.value.equals(""))
            while (!this.value.equals("")){
                try {
                    this.wait();   //不是空串就等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //如果value是空串就设置
            this.value = System.currentTimeMillis()+"_"+System.nanoTime();
            System.out.println(Thread.currentThread().getName()+" 的值是："+value);
            //this.notify();  生产者一直唤醒生产者，消费者一直唤醒消费者，就会导致假死
            this.notifyAll();
        }
    }
    public void getValue() {
        synchronized (this) {
            //while (!this.value.equals(""))
            while (this.value.equals("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" 的值是："+this.value);
            this.value = "";
            //this.notify(); 在多生产者多消费者环境中,notify()不能保证是生产者唤醒消费者,如果生产者唤醒的还是生产者可能会出现假死的情况
            this.notifyAll();
        }
    }
}
