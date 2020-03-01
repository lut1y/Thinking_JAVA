import java.util.*;

/**
 * Created by Dmitriy on 11.12.2019.
 */
public class Task14 {
    private static Integer k;

    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> list = new LinkedList<Integer>();
        java.util.ListIterator<Integer> it = list.listIterator();
        for(int i=0; i < 100; i ++) {
            if (list.size() < 2)
                it.add(rand.nextInt(100));
            else {
                if(list.size() % 2 == 0)
                        it.previous();
                it.add(rand.nextInt(100));
            }
        }
        for(Integer e: list)
            System.out.println(e);

    }
}
