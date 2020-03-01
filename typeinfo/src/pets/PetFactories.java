package pets;
import factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PetFactories {
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Pet>> petFactories =
            new ArrayList<Factory<? extends Pet>>();

    static {
        // Для Collections.addAll() выдается предупреждение
        // "неконтролируемое создание обобщенного массива"
        // Добавляем в список объекты классаов-фабрик
        petFactories.add(new Pet.Factory());
        petFactories.add(new Dog.Factory());
        petFactories.add(new Cat.Factory());
        petFactories.add(new Rodent.Factory());
        petFactories.add(new Mutt.Factory());
        petFactories.add(new Pug.Factory());
        petFactories.add(new EgyptianMau.Factory());
        petFactories.add(new Manx.Factory());
        petFactories.add(new Cymric.Factory());
        petFactories.add(new Rat.Factory());
        petFactories.add(new Mouse.Factory());
        petFactories.add(new Hamster.Factory());
        petFactories.add(new Gerbil.Factory());
    }

    private static Random rand = new Random(47);

    public static Pet createRandom() {
        int n = rand.nextInt(petFactories.size());
        return petFactories.get(n).create();
    }
}
