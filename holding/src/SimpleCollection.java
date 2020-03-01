import java.util.*;

/**
 * Created by 123 on 07.11.2019.
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<Integer>();

        for(int i=0; i<10; i++)
            c.add(i); // Автоматическая упаковка
        for(Integer i: c)
            System.out.print(i + ", ");

        System.out.println();

        Set<Integer> s = new HashSet<Integer>();
        for(int i=0; i<10; i++)
            s.add(i);
        for(Integer i : s)
            System.out.print(i + ", ");
    }
}
