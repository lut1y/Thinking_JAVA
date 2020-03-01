import util.TypeCounter;

import static util.Print.print;
import static util.Print.printnb;

/**
 * Created by Dmitriy on 30.01.2020.
 */
public class Task13 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Part.class);
        Part part = null;
        for(int i=0; i<20; i++) {
            part = Part.createRandom();
            printnb(part.getClass().getSimpleName() + " ");
            counter.count(part);
        }
        print();
        print(counter);
    }

}
