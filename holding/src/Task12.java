import java.util.*;

/**
 * Created by Dmitriy on 11.12.2019.
 */
public class Task12 {
    private static Integer i;

    public static void main(String[] args) {
        GeneratorInteger gi = new GeneratorInteger();
        List<Integer> list = new ArrayList<Integer>(gi.arrayInteger(5));
        List<Integer> list1 = new ArrayList<Integer>();
        java.util.ListIterator<Integer> it = list.listIterator();
        while(it.hasNext()) {
            i = it.next();
            System.out.println(i);
        }
        System.out.println("***");
        while(it.hasPrevious()) {
            i = it.previous();
            System.out.println(i);
            list1.add(i);
        }
    }
}
