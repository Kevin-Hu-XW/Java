package jvm;

public class Car {
    public String toString(){
        return "hello world";
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());

        Class<? extends Car> aClass = car1.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(aClass);
        System.out.println(classLoader);
        Class<? extends Car> aClass1 = car2.getClass();
        ClassLoader classLoader1 = aClass.getClassLoader();
        System.out.println(aClass1);
        System.out.println(classLoader1);
    }
}
