import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Dmitriy on 17.12.2019.
 */

public class Task23 {
    private static Random rand = new Random(47);
    private static Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    private static Map<Integer, Integer> randomMap() {
        for(int i =0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        return m;
    }
    private static Map<Integer, Integer> sumMap(Map<Integer, Integer> m1, Map<Integer, Integer> m2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Integer e : m1.keySet()) {
            Integer freq = m1.get(e);
            map.put(e, freq);
        }
        System.out.println(m1);
        for(Integer e : m2.keySet()) {
            Integer freq = m2.get(e);
            map.put(e, map.get(e) == null ? freq : map.get(e) + freq);
        }
        System.out.println(m2);
        return map;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map = sumMap(map, randomMap());
        System.out.println("map: " + map);
        map = sumMap(map, randomMap());
        System.out.println("map: " + map);
    }

}
