import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import static util.Print.print;

// Связывание ключей со значениями.
public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }
    public void put(K key, V value) {
        if(index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{ key, value};
    }
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map =
                new AssociativeArray<String, String>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            print("Too many objects!");
        }
        print(map);
        print(map.get("ocean"));
        print("***");
        TreeMap<String, String> treeMap =
                new TreeMap<String, String>();
        treeMap.put("sky", "blue");
        treeMap.put("grass", "green");
        treeMap.put("ocean", "dancing");
        treeMap.put("tree", "tall");
        treeMap.put("earth", "brown");
        treeMap.put("sun", "warm");
        try {
            treeMap.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            print("Too many objects!");
        }
        print(treeMap);
        print(treeMap.get("ocean"));
        print("***");
        LinkedHashMap<String, String> linkedHashMap =
                new LinkedHashMap<String, String>(6);
        linkedHashMap.put("sky", "blue");
        linkedHashMap.put("grass", "green");
        linkedHashMap.put("ocean", "dancing");
        linkedHashMap.put("tree", "tall");
        linkedHashMap.put("earth", "brown");
        linkedHashMap.put("sun", "warm");
        try {
            linkedHashMap.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            print("Too many objects!");
        }
        print(linkedHashMap);
        print(linkedHashMap.get("ocean"));
    }
}
