import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Dmitriy on 11.11.2019.
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> inset = new HashSet<Integer>();
        for(int i=0; i < 10000; i++)
            inset.add(rand.nextInt(30));
        System.out.println(inset);
    }
}
