import java.util.ArrayList;
import java.util.Iterator;

public class Task8 {
    public static void main(String[] args) {
        ArrayList<Gerbil> g = new ArrayList<Gerbil>();
        g.add(new Gerbil(1));
        g.add(new Gerbil(2));
        g.add(new Gerbil(3));

        Iterator<Gerbil> iterator = g.iterator();
        while(iterator.hasNext()) {
            Gerbil gerbil = iterator.next();
            gerbil.hop();
        }

//        g.add(new Gerbil(1));
//        g.add(new Gerbil(2));
//        g.add(new Gerbil(3));
//
//        for(int i=0; i < g.size(); i++) {
//            g.get(i).hop();
//        }
    }
}
