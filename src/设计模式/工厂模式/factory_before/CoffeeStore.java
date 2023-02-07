package 设计模式.工厂模式.factory_before;
/*
    设计模式的缺点：后续添加咖啡，需要修改orderCoffee中的代码，违背了开闭原则，对修改关闭
    CoffeeStore中创建Coffee对象需要通过new实现，使得CoffeeStore与Coffee严重耦合，假如要更换对象，则所有new对象的地方
    都需要修改一遍，违背了开闭原则，如果使用工厂来生产对象，则只要和工厂打交道，彻底和对象解耦，
    如果要更换对象，直接在工厂更换对象即可，达到了解耦目的

 */
public class CoffeeStore{
    public Coffee orderCoffee(String type){
        Coffee coffee = null;
        if (type=="America"){
            coffee = new AmericanCoffee();
        }else if (type=="Latte"){
            coffee = new LatteCoffee();
        }
        else{
            throw new RuntimeException("您所点的咖啡没有！");
        }
        //加糖，加奶
        coffee.addsugar();
        coffee.addmilk();
        return coffee;
    }
}
