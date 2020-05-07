import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Countries.capitals;
import static util.Countries.names;
import static util.Print.print;
import static util.Print.printnb;

public class Task2 {
    public static Map<String, String> mapCountries = new HashMap<String, String>(capitals());
    public static Set<String> setCountries = new HashSet<String>(names());
    public static void main(String[] args) {
        print(mapCountries);
        print(setCountries);
//        print("Count: " + mapCountries.keySet().size());
        Matcher m = Pattern.compile("^[A]+", Pattern.CASE_INSENSITIVE).matcher("");
        for (String name : mapCountries.keySet()) {
            m.reset(name);
            while (m.find()) {
                print(name + " : " + mapCountries.get(name));
            }
        }
        printnb("[");
        for (String name : setCountries) {
            m.reset(name);
            while (m.find())
                printnb(name + ", ");
        }
        printnb("]\n");
    }
}
