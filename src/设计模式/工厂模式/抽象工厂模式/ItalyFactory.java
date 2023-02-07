package 设计模式.工厂模式.抽象工厂模式;

//意大利风味甜点工厂
public class ItalyFactory implements DessertCoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Tilamisu();
    }
}
