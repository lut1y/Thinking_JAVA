package coffee;

import factory.Factory;
import java.util.*;

public class CoffeeFactories {
    public String toString() {
        return getClass().getSimpleName();
    }

    public static List<Factory<? extends Coffee>> coffeeFactories =
            new ArrayList<Factory<? extends Coffee>>();

    static {
//        coffeeFactories.add(new Americano.Factory());
//        coffeeFactories.add(new Breve.Factory());
//        coffeeFactories.add(new Cappuccino.Factory());
//        coffeeFactories.add(new Latte.Factory());
//        coffeeFactories.add(new Mocha.Factory());
    }

    private static Random rand = new Random(47);
    public static Coffee createRandom() {
        int n = rand.nextInt(coffeeFactories.size());
        return coffeeFactories.get(n).create();
    }
}
