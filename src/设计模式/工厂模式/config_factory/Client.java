package 设计模式.工厂模式.config_factory;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("Person");
        System.out.println(coffee.getName());
    }
}
