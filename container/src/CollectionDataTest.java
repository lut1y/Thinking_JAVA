import util.CollectionData;
import util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

class Goverment implements Generator<String> {
    String[] foundation = ("strange women luing in ponds " +
            "distributing swords is no basis for a system of " +
            "goverment").split(" ");
    private int index;
    public String next() {
        return foundation[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(
                new CollectionData<String>(new Goverment(), 15));
        System.out.println(set);
        set.addAll(CollectionData.list(new Goverment(), 15));
        System.out.println(set);
    }
}
