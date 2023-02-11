package design_pattern.工厂模式.抽象工厂模式;

//美式甜点工厂
public class AmericanFactory implements DessertCoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Mochamus();
    }
}
