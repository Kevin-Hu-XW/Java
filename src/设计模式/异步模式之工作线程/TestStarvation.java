package 设计模式.异步模式之工作线程;
/*
    不同任务类型应该使用不同的线程池，这样能够避免饥饿，并能提升效率
 */
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

//饥饿
public class TestStarvation {
    static final List<String> MENU = Arrays.asList("地三鲜", "宫保鸡丁", "辣子鸡丁", "烤鸡翅");
    static Random random = new Random();
    static String Cooking(){
        return MENU.get(random.nextInt(MENU.size()));
    }
    public static void main(String[] args) {
        ExecutorService waiterPool = Executors.newFixedThreadPool(1);
        ExecutorService cookerPool = Executors.newFixedThreadPool(1);

        waiterPool.execute(()->{
            System.out.println(Thread.currentThread().getName()+"点餐处理");
            Future<String> future = cookerPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(Thread.currentThread().getName()+"做菜");
                    return Cooking();
                }
            });
            try {
                String food= future.get();
                System.out.println(Thread.currentThread().getName()+"上"+food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        waiterPool.execute(()->{
            System.out.println(Thread.currentThread().getName()+"点餐处理");
            Future<String> future = cookerPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(Thread.currentThread().getName()+"做菜");
                    return Cooking();
                }
            });
            try {

                String food= future.get();
                System.out.println(Thread.currentThread().getName()+"上"+food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
