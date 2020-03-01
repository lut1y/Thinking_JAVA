import java.util.*;

/**
 * Created by Dmitriy on 09.12.2019.
 */

public class Task7 {
    public static List subList(List list) {
        return list.subList(1,3);
    }

    public static void main(String[] args) {
        Gerbil[] gerbils = {new Gerbil(3), new Gerbil(5), new Gerbil(7), new Gerbil(10)};
        List<Gerbil> list = new ArrayList<Gerbil>();
        Collections.addAll(list, gerbils);
        System.out.println(list);
        List<Gerbil> sub = new ArrayList<>(subList(list));
        System.out.println(sub);
        for(Gerbil e : sub)
            if(list.contains(e))
                list.remove(e);

        System.out.println(list);
    }
}
