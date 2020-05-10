import util.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;

import static util.Print.print;

public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(new CountingMapData(10));
        print(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        print("low: " + low);
        print("high: " + high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        for(int i=0; i <= 6; i++) {
            if(i==3) low = it.next();
            if(i==6) high = it.next();
            else it.next();
        }
        print("low: " + low);
        print("high: " + high);
        print("sortedMap.subMap(low, high): " + sortedMap.subMap(low, high));
        print("sortedMap.headMap(high): " + sortedMap.headMap(high));
        print("sortedMap.tailMap(low): " + sortedMap.tailMap(low));
    }
}
