import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Dmitriy on 11.11.2019.
 */
// Простой пример использования HashMap

public class Statistic {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i =0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }
}
