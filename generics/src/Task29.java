import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task29 {
    static void f1(Holder<List<?>> holder) {
        System.out.println("holder: " + holder);
        System.out.println("holder.get(): " + holder.get());
        holder.set(Arrays.asList(1, 2, 3));
        System.out.println("holder.get(): " + holder.get());
    }
    static void f2(List<Holder<?>> list) {
        System.out.println("list: " + list);
        System.out.println("list size: " + list.size());
        list.add(new Holder(1));
        System.out.println("list: " + list.get(0));
        System.out.println((list.get(0)).get());
    }
    public static void main(String[] args) {
        f1(new Holder<List<?>>());
        System.out.println();
        List<Holder<?>> list = new ArrayList<Holder<?>>();
        f2(list);
    }
}
