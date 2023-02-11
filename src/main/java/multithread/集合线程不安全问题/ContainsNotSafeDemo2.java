package multithread.集合线程不安全问题;


public class ContainsNotSafeDemo2 {
    public static void main(String[] args) {

        //Map<String,String> map = new HashMap();
        //Map<String,String> map = Collections.unmodifiableMap();
//        Map<String,String> map = new ConcurrentHashMap<>();
//        for (int i=0;i<100;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 8));
//                    System.out.println(map);
//                }
//            }).start();
//        }
    }
}
