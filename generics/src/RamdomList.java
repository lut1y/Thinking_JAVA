import java.util.ArrayList;
import java.util.Random;

public class RamdomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);
    public void add(T item) { storage.add(item); }
    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RamdomList<String> rs = new RamdomList<String>();
        for(String s : "The quick brown fox jumped over the lazy brown dog".split(" "))
            rs.add(s);
        for(int i = 0; i < rs.storage.size(); i++)
            System.out.print(rs.select() + " ");

        System.out.println();
        RamdomList<Integer> rs1 = new RamdomList<Integer>();
        for(int i = 0; i < 10; i++)
            rs1.add(i);
        for(int i = 0; i < rs1.storage.size(); i++)
            System.out.print(rs1.select() + " ");

        System.out.println();
        RamdomList<Character> rs2 = new RamdomList<Character>();
        for(int i = 75; i < 85; i++)
            rs2.add((char) i);
        for(int i = 0; i < rs2.storage.size(); i++)
            System.out.print(rs2.select() + " ");
    }
}
