import util.TextFile;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import static util.Print.print;

public class Task13 {
    public static void main(String[] args) {
        Set<String> tf = new TreeSet<String>(new TextFile(
                "C:\\Users\\Developer\\IdeaProjects\\JAVA\\Thinking_Java\\mindview\\src\\util\\TextFile.java",
                "\\W+"));
        AssociativeArray<String, Integer> associativeArray =
                new AssociativeArray<String, Integer>(tf.size());
        ArrayList<String> words = new TextFile(
                "C:\\Users\\Developer\\IdeaProjects\\JAVA\\Thinking_Java\\mindview\\src\\util\\TextFile.java",
                "\\W+");

        for(String s : tf) {
            int count = 0;
            for(String t : words) {
                if(t.equals(s)) count++;
            }
            associativeArray.put(s, count);
        }
        print(associativeArray);
        print("***");
        Set<String> tf1 = new TreeSet<String>(new TextFile(
                "C:\\Users\\Developer\\IdeaProjects\\JAVA\\Thinking_Java\\mindview\\src\\util\\TextFile.java",
                "\\W+"));
        SlowMap<String, Integer> slowMap =
                new SlowMap<String, Integer>();

        ArrayList<String> words1 = new TextFile(
                "C:\\Users\\Developer\\IdeaProjects\\JAVA\\Thinking_Java\\mindview\\src\\util\\TextFile.java",
                "\\W+");

        for(String s : tf1) {
            int count = 0;
            for(String t : words) {
                if(t.equals(s)) count++;
            }
            slowMap.put(s, count);
        }
        print(slowMap);
    }
}
