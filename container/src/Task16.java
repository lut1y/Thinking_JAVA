import util.CountingMapData;

import javax.jnlp.IntegrationService;
import java.util.*;

import static util.Print.print;
import static util.Print.printnb;

class SlowMap16<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    private EntrySet entries = new EntrySet();
    public Set<Map.Entry<K, V>> entrySet() { return entries; }

    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public int size() { return keys.size(); }
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                private int index = -1;
                public boolean hasNext() {
                    return index < keys.size()-1;
                }
                public Map.Entry<K, V> next() {
                    int i = ++index;
                    return new MapEntry(keys.get(i), values.get(i));
                }
                public void remove() {
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }
    }

    public V get(Object obj) {
        if(!keys.contains(obj))
            return null;
        return values.get(keys.indexOf(obj));
    }
    public V put(K key, V value) {
        V oldValue = get(key);
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }
}

public class Task16 {
    public static void printKeys(Map<Integer, String> map) {
        printnb("Size = " + map.size() + ", ");
        printnb("Keys: ");
        print(map.keySet()); // Produce a set of the keys
    }

    public static void test(Map<Integer, String> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        // Map has 'Set' behavior for keys:
        map.putAll(new CountingMapData(25));
        printKeys(map);
        printnb("Values: ");
        print(map.values());
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
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.entrySet());
        print("map.isEmpty(): " + map.isEmpty());
    }

    public static void main(String[] args) {
        test(new HashMap<Integer, String>());
        print("***");
        test(new SlowMap<Integer, String>());
        print("***");
        test(new SlowMap16<Integer, String>());
    }
}
