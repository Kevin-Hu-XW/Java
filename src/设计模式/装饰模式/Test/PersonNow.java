package 设计模式.装饰模式.Test;
/**
 * 装饰类
 * (要去增强目标对象的类)
 * 装饰类通常会通过构造方法接收被装饰的对象。
 * 并基于被装饰的对象的功能，提供更强的功能。
 */
public class PersonNow implements Person {

    private PersonBefore personBefore;

    PersonNow(PersonBefore personBerfore){
        this.personBefore = personBerfore;
    }
    @Override
    public void eat() {
        personBefore.eat();
        System.out.println("很咸");
        System.out.println("很甜");

    }
}
