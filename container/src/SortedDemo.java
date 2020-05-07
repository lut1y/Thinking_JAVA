import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import static util.Print.print;

// Операции с TreeSet
public class SortedDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet,
                "one two three four five six seven eight".split(" "));
        print(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        print("low: " + low);
        print("high: " + high);
        Iterator<String> it = sortedSet.iterator();
        for(int i=0; i <= 6; i++) {
            if(i==3)
                low = it.next();
            if(i==6)
                high = it.next();
            else it.next();
        }
        print("low: " + low);
        print("high: " + high);
        print("SortedSet: " + sortedSet);
        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(high));
        print(sortedSet.tailSet(low));
    }
}
