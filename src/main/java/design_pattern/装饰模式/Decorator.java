package design_pattern.装饰模式;

public class Decorator extends Drink{
    private Drink drink;
    Decorator(Drink drink){
        this.drink = drink;
    }
    @Override
    public float cost() {
        return super.getPrice()+drink.cost();
    }

    //输出被装饰者的信息
    public String getDes() {
        return super.getDes()+" "+getPrice()+" "+drink.getDes();
    }
}
