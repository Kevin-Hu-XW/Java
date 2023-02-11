package design_pattern.工厂模式.简单工厂模式;

/*
    分析：
    1、工厂处理创建对象的细节，一旦有了SimpleCoffeeFactory，CoffeeStore类中的orderCoffee()就变成此对象的客户，
    后期如果需要Coffee对象直接从工厂中获取即可。这样也就解除了和Coffee实现类的耦合，
    同时又产生了新的耦合，CoffeeStore对象和SimpleCoffeeFactory工厂对象的耦合，工厂对象和商品对象的耦合。
    2、后期如果再加新品种的咖啡，我们势必要需求修改SimpleCoffeeFactory的代码，违反了开闭原则。
    工厂类的客户端可能有很多，比如创建美团外卖等，这样只需要修改工厂类一处的代码即可，省去其他的修改操作。


    优点：封装了创建对象的过程，把对象的创建和业务逻辑分开，这样以后避免了修改客户端代码，如果要实现新产品，直接修改
          工厂类，不需要在原代码中修改，这样就降低了客户代码修改的可能性，更加任意扩展
    缺点：增加新产品还要修改工厂类，违反开闭原则
 */
public class CoffeeStore{
    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);
        //加糖，加奶
        coffee.addsugar();
        coffee.addmilk();
        return coffee;
    }
}
