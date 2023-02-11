package design_pattern.装饰模式;

public class CoffeeBar {
    public static void main(String[] args) {

        //装饰者模式下下订单：2份牛奶+一份巧克力的LongBlack

        Drink drink = new LongBlack();
        System.out.println("费用"+drink.cost());
        System.out.println("描述"+drink.getDes());

        //加入一份牛奶
        drink = new Milk(drink);
        System.out.println("drink加入一份牛奶，费用="+drink.cost());
        System.out.println("drink加入一份牛奶，描述"+drink.getDes());

        //加入一份巧克力
        drink = new Chocolate(drink);
        System.out.println("drink加入一份牛奶，再加入一份巧克力，费用="+drink.cost());
        System.out.println("drink加入一份牛奶，再加入一份巧克力，描述"+drink.getDes());

    }
}
