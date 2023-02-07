package 面向对象.多态;

public class Test {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Cat cat = new Cat();
        zooKeeper.eat(cat);

        Dog dog = new Dog();
        zooKeeper.eat(dog);

    }
}
