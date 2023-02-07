package 面向对象.多态;

public class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("cat eat fish!");
    }
    public void play(){
        System.out.println("playing");
    }
}
