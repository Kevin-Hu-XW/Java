package jdk8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @date 2023/2/7 21:55
 */
@Data
@AllArgsConstructor
public class Person {

    private String name;
    private int salary;
    private int age;
    private String sex;
    private String area;

    public static List<Person> assemblePersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        return personList;
    }

}
