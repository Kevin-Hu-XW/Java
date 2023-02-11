package design_pattern.装饰模式;

public class Soy extends Decorator{

    public Soy(Drink obj) { super(obj);
        setDes(" 豆浆	"); setPrice(1.5f);
    }

}
