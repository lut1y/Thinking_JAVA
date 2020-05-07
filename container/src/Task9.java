import util.CollectionData;
import util.RandomGenerator;
import java.util.Set;
import java.util.TreeSet;

import static util.Print.print;

public class Task9 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>(
                new CollectionData<String>(new RandomGenerator.String(), 5));

        print(set);
    }
}
