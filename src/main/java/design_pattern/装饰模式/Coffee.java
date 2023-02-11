package design_pattern.装饰模式;

public class Coffee extends Drink{
    @Override
    public float cost() {
        return super.getPrice();
    }
}
