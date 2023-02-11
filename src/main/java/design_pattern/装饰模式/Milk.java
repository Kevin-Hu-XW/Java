package design_pattern.装饰模式;

public class Milk extends Decorator{


    public Milk(Drink obj) { super(obj);
        setDes("牛奶"); setPrice(2.0f);
    }

}
