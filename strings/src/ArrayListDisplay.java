import coffee.Coffee;
import coffee.CoffeeGenerator;
import java.util.ArrayList;
import static util.Print.printnb;

public class ArrayListDisplay {
    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<Coffee>();
        for(Coffee c : new CoffeeGenerator(10))
            coffees.add(c);
        printnb(coffees);
    }
}
