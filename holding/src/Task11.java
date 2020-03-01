import java.util.*;

/**
 * Created by Dmitriy on 11.12.2019.
 */
public class Task11 {
    private static String s;

    public static void display(Iterator<String> it) {
        while (it.hasNext()) {
            s = it.next();
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        GeneratorString gs = new GeneratorString();
        Collection<String> list = new ArrayList<String>(gs.arrayString(5));
        Iterator<String> iterator = list.iterator();
        display(iterator);

    }
}
