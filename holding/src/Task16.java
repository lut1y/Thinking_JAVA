import java.util.*;

/**
 * Created by Dmitriy on 13.12.2019.
 */
public class Task16 {
    private static final String s = "public static void main (String[] args)";
    private static String glasn = "aeiou";
    private static int numGl;
    private static int numCom=0;

    public static void main(String[] args) {
        Set<Character> characters = new HashSet<Character>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(char e : glasn.toCharArray()) {
            characters.add(e);
        }
        for(String e : s.split(" ")) {
            numGl = 0;
            for(Character ch : characters)
                if (e.contains(ch.toString()))
                    numGl = numGl + 1;
            System.out.println(e + " : " + numGl);
            numCom = numCom + numGl;
        }
        System.out.println("Общее число гласных: " + numCom);

        System.out.println("***");
        for(char e : glasn.toCharArray()) {
            map.put(e, 0);
        }

        for(Character e : map.keySet()) {
            for(Character ch : s.toCharArray()) {
                if(ch==e) map.replace(e, map.get(e) + 1);
            }
        }

        for(Character e : map.keySet()) {
            System.out.println(e + " : " + map.get(e));
        }

    }



}
