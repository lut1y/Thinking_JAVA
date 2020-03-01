import java.util.*;

/**
 * Created by Dmitriy on 17.12.2019.
 */

class WordCount {
    private String word;
    private int count=0;

    public WordCount(String word) {
        this.word = word;
        this.count = 1;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

public class Task22 {
    private static boolean sovp;
    private static String s = "public static void main ( String [] args) public main String";
    private static Map<String, Integer> map = new HashMap<String, Integer>();

    private static boolean hasWord(WordCount wc, String w) {
        if(wc.getWord().equals(w))
            return true;
        return false;
    }

    public static void main(String[] args) {
        for(String e : s.split(" ")) {
            if(map.containsKey(e)) {
                map.replace(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }

        List<String> words = new ArrayList<String>(map.keySet());
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);

        for(String e : words)
            System.out.println(e + " : " + map.get(e));

        System.out.println("***");
        Set<WordCount> wordCountSet = new HashSet<WordCount>();


        for(String e : s.split(" ")) {
            sovp = false;
            for (WordCount wc : wordCountSet) {
                if (hasWord(wc, e)) {
                    sovp = true;
                    wc.setCount(wc.getCount() + 1);
                    break;
                }
            }
            if (!sovp) {
                wordCountSet.add(new WordCount(e));
            }
        }
        for(WordCount wc : wordCountSet)
            System.out.println(wc.getWord() + " : " + wc.getCount());
    }
}
