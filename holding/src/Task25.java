import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitriy on 19.12.2019.
 */
public class Task25 {
    private static Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    private static final String s = "public static void main ( String[] args ) public static void";

    private static void decodeMap(Map<String, ArrayList<Integer>> map) {
        int maxInt = 0;

        for(String e : map.keySet())
            for(Integer i : map.get(e))
                if(maxInt < i) maxInt = i;
        System.out.println(maxInt);

        int i = 1;
        String words = "";
        while(true) {
            if(i>maxInt) {
                System.out.println(words);
                break;
            }
            for(String e : map.keySet())
                for(Integer ii : map.get(e))
                    if(ii == i) words = words + e + " ";
            i += 1;
        }
    }

    public static void main(String[] args) {
        int i = 0;
        for(String e : s.split(" ")) {
            i += 1;
            if(map.keySet().contains(e)) {
                map.get(e).add(i);
            } else {
                map.put(e, new ArrayList<Integer>());
                map.get(e).add(i);
            }
        }

        for(String e : map.keySet()) {
            System.out.print("\"" + e + "\": ");
            for(Integer ii : map.get(e)) {
                System.out.print(ii + " ");
            }
            System.out.println();
        }

        // Task26
        decodeMap(map);
        System.out.println(s);
    }
}
