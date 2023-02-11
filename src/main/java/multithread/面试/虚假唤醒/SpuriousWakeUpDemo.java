package multithread.面试.虚假唤醒;
/*
    因为if只会执行一次，执行完会接着向下执行if（）外边的
    而while不会，直到条件满足才会向下执行while（）外边的
 */
class Clerk{
    public int total = 1;
    int num = 0;
    public synchronized void buy(){
        try {
            while (num>=total){
                this.wait();
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " +"....................进货成功，剩下"+num++);
        this.notify();
    }
    public synchronized void sale(){
        try {
            while (num<=0){
                this.wait();
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " +"....................卖货成功，剩下"+num--);
        this.notify();
    }
}
class Consumer{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    public void run(){
        for (int i=0;i<10;i++){
            clerk.sale();
        }
    }
}
class Produce{
    private Clerk clerk;
    public Produce(Clerk clerk){
        this.clerk = clerk;
    }

    public void run(){
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.buy();
        }
    }
}
public class SpuriousWakeUpDemo {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Consumer consumer = new Consumer(clerk);
        Produce produce = new Produce(clerk);
        new  Thread(new Runnable() {
            @Override
            public void run() {
                consumer.run();
            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                produce.run();
            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                consumer.run();
            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                produce.run();
            }
        }).start();

    }

}
