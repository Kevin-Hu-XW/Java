package design_pattern.工厂模式.工厂方法模式;


/*
    工厂方法模式：考虑的是一类产品的生产，如畜牧场只养动物、电视机厂只生产电视机
    优点：
    1、用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；
    2、在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；
    缺点：
    1、每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。
       如果咖啡的种类特别多就会产生类爆炸
 */
public class CoffeeStore{
    private CoffeeFactory factory;
    public CoffeeStore(CoffeeFactory factory){
        this.factory = factory;
    }
    public Coffee orderCoffee(){
        Coffee coffee = factory.createCoffee();
        //加糖，加奶
        coffee.addsugar();
        coffee.addmilk();
        return coffee;
    }
}
