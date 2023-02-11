package design_pattern.UML;


public class Person {
    static {
        System.out.println("Person");
    }
    private String name;
    private int age;
    public Person(){
        this.name = "kevin";
        this.age = 20;

    }
    public void print(){
        System.out.println("name"+name+":");
        System.out.println("age"+age+":");
    }
}
