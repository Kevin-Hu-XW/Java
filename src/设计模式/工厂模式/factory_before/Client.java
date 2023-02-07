package 设计模式.工厂模式.factory_before;

public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("Latte");
        System.out.println(coffee.getName());
    }
}
