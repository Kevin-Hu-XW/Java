package design_pattern.工厂模式.简单工厂模式;
/*
    简单咖啡工厂类
 */
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if (type=="America"){
            coffee = new AmericanCoffee();
        }else if (type=="Latte"){
            coffee = new LatteCoffee();
        }
        else{
            throw new RuntimeException("您所点的咖啡没有！");
        }

        return coffee;
    }
}
