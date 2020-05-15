import util.TextFile;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Task19 {
    private static String pathFile = "C:\\Users\\Developer\\IdeaProjects\\JAVA\\" +
            "Thinking_Java\\container\\src\\Task19.java";

    public static Set<String> setWords = new TreeSet<String>(
            new TextFile(pathFile, "\\W+"));

    public static void main(String[] args) {
        SimpleHashMap<String, Integer> wordMap = new SimpleHashMap<String, Integer>();
        ArrayList<String> allWords = new TextFile(pathFile, "\\W+");
        for(String word : allWords) {
            if(!wordMap.containsKey(word))
                wordMap.put(word, 1);
            else
                wordMap.put(word, wordMap.get(word)+1);
        }
        for (String word : wordMap.keySet()) {
            System.out.println(word + " : " + wordMap.get(word));
        }
    }

}
