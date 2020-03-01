import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy on 16.01.2020.
 */
public class Groups {
    public static final String POEM =
            "Twas brilling, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and, sun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s(\\S+))$")
                .matcher(POEM);
        while(m.find()) {
            for(int j=0; j <= m.groupCount(); j++)
                System.out.print("[" + m.group(j) + "]");
            System.out.println();
        }

        // Уникальные слова
        System.out.println("*****");
        Map<String, Integer> mapWords = new HashMap<String, Integer>();
        m = Pattern.compile("[A-Z]+\\w+")
                .matcher(POEM);
        String s;
        while(m.find()) {
            s="";
            s = m.group();
            if (mapWords.containsKey(s)) {
                mapWords.put(s, mapWords.get(s) + 1);
            }
            else {
                mapWords.put(s, 1);
            }
        }

        for(String word : mapWords.keySet()) {
            System.out.println(word + " : " + mapWords.get(word));
        }
    }
}
