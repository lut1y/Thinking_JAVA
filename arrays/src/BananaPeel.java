import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Banana { void peel(int i) { /* ... */ } }

class Peel<T> {

}

public class BananaPeel {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Banana a = new Banana(),
                b = new Banana();
        a.peel(1);
        b.peel(2);

        Peel<Banana> pb = new Peel<Banana>();
        List<Banana>[] pb1 = (List<Banana>[]) new List[10];
        System.out.println(Arrays.toString(pb1));
    }
}