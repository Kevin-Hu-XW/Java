package 基础.容器;



import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Test1 {
    public static void main(String[] args) {
        TreeMap<String,String> map = new TreeMap<>();
        map.put("1","1");
        map.put("3","3");
        map.put("2","2");
        System.out.println("通过entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey()+": "+next.getValue());
        }
    }



}
