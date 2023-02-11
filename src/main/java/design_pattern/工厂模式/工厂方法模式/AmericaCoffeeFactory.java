package design_pattern.工厂模式.工厂方法模式;
/*
    美式咖啡对象工厂对象，专门用来生产美式咖啡
 */
public class AmericaCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
