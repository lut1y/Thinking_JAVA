import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 13.01.2020.
 */
public class InfiniteRecursion {
    public String toString() {
        return "InfiniteRecursion adress: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for(int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.print(v);
    }
}
