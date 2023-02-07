package 设计模式.装饰模式.Test;

/*
    被装饰的类
    被增强的对象
 */
public class PersonBefore implements Person {

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
