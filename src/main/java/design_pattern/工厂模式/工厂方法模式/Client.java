package design_pattern.工厂模式.工厂方法模式;

public class Client {
    public static void main(String[] args) {

        CoffeeFactory factory = AmericanCoffee::new;
        CoffeeStore store = new CoffeeStore(factory);
        Coffee coffee = store.orderCoffee();
        System.out.println(coffee.getName());

    }
}
