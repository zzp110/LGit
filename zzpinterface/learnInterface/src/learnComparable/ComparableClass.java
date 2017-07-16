package learnComparable;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableClass {
    public static void main(String[] args){
        ArrayList arr = new ArrayList();
        arr.add(new Student("Jack",10));
        arr.add(new Student("Bill",23));
        arr.add(new Student("Rudy",7));

        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
    }
}
