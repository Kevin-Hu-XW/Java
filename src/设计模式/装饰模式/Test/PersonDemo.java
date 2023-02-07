package 设计模式.装饰模式.Test;

public class PersonDemo {
    public static void main(String[] args) {
        //未增强之前
        PersonBefore personBefore = new PersonBefore();
        personBefore.eat();
        System.out.println("***************************");
        //增强后
        PersonNow personNow = new PersonNow(personBefore);
        personNow.eat();
    }
}
