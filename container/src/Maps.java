import util.CountingMapData;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Properties;

import static util.Print.print;
import static util.Print.printnb;

public class Maps {
    public static void printKeys(Map<Integer, String> map) {
        printnb("Size = " + map.size() + ", ");
        printnb(" Keys: ");
        print(map.keySet());
    }

    public static void printKeys2(Map<Object, Object> map) {
        printnb("Size = " + map.size() + ", ");
        printnb(" Keys: ");
        print(map.keySet());
    }

    public static void test(Map<Integer, String> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        printnb("Values: ");
        print(map);
        print("map.containsKey(11): " + map.containsKey(11));
        print("map.get(11): " + map.get(11));
        print("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        print("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty(): " + map.isEmpty());
        print("***");
    }

    public static void test2(Map<Object, Object> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        printnb("Values: ");
        print(map);
        print("map.containsKey(11): " + map.containsKey(11));
        print("map.get(11): " + map.get(11));
        print("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Integer key = (Integer) map.keySet().iterator().next();
        print("First key in map: " + key);
        map.remove(key);
        printKeys2(map);
        map.clear();
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty(): " + map.isEmpty());
        print("***");
    }

    public static void main(String[] args) {
        test(new HashMap<Integer, String>());
        test(new TreeMap<Integer, String>());
        test(new LinkedHashMap<Integer, String>());
        test(new IdentityHashMap<Integer, String>());
        test(new ConcurrentHashMap<Integer, String>());
        test(new WeakHashMap<Integer, String>());
        test2(new Properties());
    }
}
