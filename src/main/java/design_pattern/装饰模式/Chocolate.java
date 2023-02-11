package design_pattern.装饰模式;

public class Chocolate extends Decorator{

    public Chocolate(Drink obj) { super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f); // 调味品 的价格
    }


}
