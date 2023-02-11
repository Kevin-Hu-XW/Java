package design_pattern.反射;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("design_pattern.UML.Person");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
