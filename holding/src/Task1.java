import java.util.ArrayList;

/**
 * Created by Dmitriy on 09.12.2019.
 */
class Gerbil {
    private int gerbilNumber;
    Gerbil(int i) {
        gerbilNumber = i;
    }
    public void hop() {
        System.out.println("Gebril.hop(): " + gerbilNumber);
    }
}

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Gerbil> g = new ArrayList<Gerbil>();
        g.add(new Gerbil(1));
        g.add(new Gerbil(2));
        g.add(new Gerbil(3));

        for(int i=0; i < g.size(); i++) {
            g.get(i).hop();
        }
    }
}
