package 多线程.并发访问.案例2;

public class Test {
    public static void main(String[] args) {
        Toilet toilet = new Toilet();
        Human human1 = new Human("1",toilet);
        Human human2 = new Human("2",toilet);
        Human human3 = new Human("3",toilet);
    }
}
