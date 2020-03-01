import java.util.*;

/**
 * Created by Dmitriy on 18.12.2019.
 */
public class Task24 {
    private static  Map<String, String> map = new LinkedHashMap<String, String>();

    public static void main(String[] args) {
        map.put("Собака", "Джек");
        map.put("Кошка", "Мурка");
        map.put("Таракан", "Степан");
        map.put("Удав", "Ильич");
        map.put("Собака", "Шарик");

        List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);

        for(String e : keys)
            map.put(e, map.get(e));

        System.out.println(map);


    }
}
