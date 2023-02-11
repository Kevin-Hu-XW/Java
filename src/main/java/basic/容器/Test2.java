package basic.容器;

import java.util.HashMap;
import java.util.Iterator;

public class Test2 {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","kevin");
        map.put("2","otm");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if (key.equals("1"))
                //map.remove(key);
                iterator.remove();
        }
        System.out.println(map.get("2"));
    }
}
