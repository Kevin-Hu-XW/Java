package basic.容器;

import java.util.Enumeration;
import java.util.Hashtable;

public class MyHashTable {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        ht.put("1", "One");
        ht.put("2", "Two");
        ht.put("3", "Three");
        Enumeration elements = ht.elements();
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
    }
}
