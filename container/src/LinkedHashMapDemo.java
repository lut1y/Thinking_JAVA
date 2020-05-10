import util.CountingMapData;

import java.util.LinkedHashMap;

import static util.Print.print;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap =
                new LinkedHashMap<Integer, String>(new CountingMapData(9));
        print("linkedHashMap: " + linkedHashMap);
        // порядок LRU (least-recently-used - наиболее используемые идут первыми)
        linkedHashMap =
                new LinkedHashMap<Integer, String>(16, 0.75f, true);
        linkedHashMap.putAll(new CountingMapData(9));
        print("linkedHashMap(LRU): " + linkedHashMap);
        for(int i=0; i<6; i++)
            linkedHashMap.get(i);
        print("linkedHashMap(LRU): " + linkedHashMap);
        linkedHashMap.get(0);
        print("linkedHashMap(LRU): " + linkedHashMap);
    }
}
