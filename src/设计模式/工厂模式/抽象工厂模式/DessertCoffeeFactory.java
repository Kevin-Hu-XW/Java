package 设计模式.工厂模式.抽象工厂模式;

public interface DessertCoffeeFactory {

    //生产咖啡功能
    Coffee createCoffee();
    //生产甜品功能
    Dessert createDessert();
}
