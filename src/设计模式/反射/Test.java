package 设计模式.反射;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("设计模式.UML.Person");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
