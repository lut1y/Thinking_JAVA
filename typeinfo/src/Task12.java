import coffee.Coffee;
import coffee.CoffeeGenerator;
import util.TypeCounter;

import static util.Print.print;
import static util.Print.printnb;

/**
 * Created by Dmitriy on 28.01.2020.
 */
public class Task12 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Coffee.class);
        for(Coffee coffee : new CoffeeGenerator(20)) {
            printnb(coffee.getClass().getSimpleName() + " ");
            counter.count(coffee);
        }
        print();
        print(counter);
    }
}
