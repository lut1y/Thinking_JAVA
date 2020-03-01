import java.util.*;

/**
 * Created by Dmitriy on 16.12.2019.
 */
public class Task19 {
    private static Map<String, Integer> hm = new HashMap<String, Integer>();
    private static Set<String> s = new HashSet<String>();

    public static void main(String[] args) {
        hm.put("One", 1);
        hm.put("Two", 2);
        hm.put("Three", 3);
        hm.put("Four", 4);
        hm.put("Nine", 9);
        hm.put("Ten", 10);
        hm.put("Five", 5);

        System.out.println("HashMap и LinkedHashMap");

        for(String e : hm.keySet())
            System.out.println(e + "(" + e.hashCode() + ")" + " : " + hm.get(e));

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();

        Set<String> sortKeys = new TreeSet<String>(hm.keySet());

        for(String e : sortKeys) {
            lhm.put(e, hm.get(e));
        }

        System.out.println("***");
        for(String e: lhm.keySet()) {
            System.out.println(e + "(" + e.hashCode() + ")" + " : " + hm.get(e));
        }

        System.out.println("HashSet и LinkedHashSet");
        s.add("One");
        s.add("Two");
        s.add("Three");
        s.add("Four");
        s.add("Nine");
        s.add("Ten");
        s.add("One");
        s.add("Nine");
        s.add("Five");

        Set<String> s1 = new LinkedHashSet<String>(new TreeSet<String>(s));
        for(String e: s1)
            System.out.println(e);
    }
}
