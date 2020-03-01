import java.util.*;

/**
 * Created by 123 on 07.11.2019.
 */
// Контейнеры распечатываются автоматически

public class PrintingContainers {
    static Collection fill(Collection<String> collection) {
        collection.add("крыса");
        collection.add("кошка");
        collection.add("собака");
        collection.add("собака");
        return collection;
    }
    static Map fill(Map<String, String> map) {
        map.put("крыса", "Анфиса");
        map.put("кошка", "Мурка");
        map.put("собака", "Шарик");
        map.put("собака", "Бобик");
        return map;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList " + fill(new ArrayList<String>()));
        System.out.println("LinkedList " + fill(new LinkedList<String>()));
        System.out.println("HashSet " + fill(new HashSet<String>()));
        System.out.println("TreeSet " + fill(new TreeSet<String>()));
        System.out.println("LinkedHashSet " + fill(new LinkedHashSet<String>()));
        System.out.println("HashMap " + fill(new HashMap<String, String>()));
        System.out.println("TreeMap " + fill(new TreeMap<String, String>()));
        System.out.println("LinkedHashMap " + fill(new LinkedHashMap<String, String>()));
    }
}
