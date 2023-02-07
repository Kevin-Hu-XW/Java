package 设计模式.工厂模式.config_factory;
/*
    简单工厂模式+配置文件解除耦合
 */
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {
    private static Map<String,Coffee> map = new HashMap<>();
    static {
        Properties properties = new Properties();
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(is);
            //遍历Properties对象集合
            Set<Object> keySet = properties.keySet();
            for (Object key:keySet){
                //根据键值获取全类名
                String name = properties.getProperty((String) key);
                Class clazz = Class.forName(name);
                Coffee coffee = (Coffee) clazz.newInstance();
                map.put((String)key,coffee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Coffee createCoffee(String name){
        return map.get(name);
    }
}
