import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Dmitriy on 16.12.2019.
 */
public class Task17 {
    public static void main(String[] args) {
        Map<String, Gerbil> gerbilMap = new HashMap<String, Gerbil>();

        gerbilMap.put("One", new Gerbil(1));
        gerbilMap.put("Two", new Gerbil(2));
        gerbilMap.put("Three", new Gerbil(3));
        gerbilMap.put("Four", new Gerbil(4));

        String g;
        Iterator<String> iterator = gerbilMap.keySet().iterator();
        while (iterator.hasNext()) {
            g = iterator.next();
            System.out.print(g + " ");
            gerbilMap.get(g).hop();
        }
    }
}
