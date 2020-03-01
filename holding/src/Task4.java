import java.util.*;

/**
 * Created by Dmitriy on 09.12.2019.
 */
class Generator {
    Random rand = new Random(47);
    public String next() {
        switch(rand.nextInt(3)) {
            default:
            case 0 : return "Шерлок Холмс";
            case 1 : return "Доктор Уотсон";
            case 2 : return "Миссис Хадсон";
        }

    }
}

public class Task4 {
    public static void main(String[] args) {

        Generator gen = new Generator();

        List<String> s1 = new ArrayList<String>();
        for(int i=0; i < 5; i++)
            s1.add(gen.next());

        List<String> s2 = new LinkedList<String>();
        for(int i=0; i < 5; i++)
            s2.add(gen.next());

        Set<String> s3 = new HashSet<String>();
        for(int i=0; i < 5; i++)
            s3.add(gen.next());

        HashSet<String> s4 = new LinkedHashSet<String>();
        for(int i=0; i < 5; i++)
            s4.add(gen.next());

        Set<String> s5 = new TreeSet<String>();
        for(int i=0; i < 5; i++)
            s5.add(gen.next());

        for(String e : s1)
            System.out.print(e + " ");
        System.out.println();
        for(String e : s2)
            System.out.print(e + " ");
        System.out.println();
        for(String e : s3)
            System.out.print(e + " ");
        System.out.println();
        for(String e : s4)
            System.out.print(e + " ");
        System.out.println();
        for(String e : s5)
            System.out.print(e + " ");
        System.out.println();
    }
}
