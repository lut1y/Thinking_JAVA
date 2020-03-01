package pets;

import factory.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 27.01.2020.
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types =
        new ArrayList<Class<? extends Pet>>();
    // Типы, которые должны создаваться случайным образом
    private static String[] typeNames = {
            "pets.Mutt",
            "pets.Pug",
            "pets.EgyptianMau",
            "pets.Manx",
            "pets.Cymric",
            "pets.Rat",
            "pets.Mouse",
            "pets.Hamster",
            "pets.Gerbil"
    };
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for(String name : typeNames)
                types.add(
                        (Class<? extends Pet>)Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static { loader(); } // инициализация класса, в первую очередь
    public List<Class<? extends Pet>> types() { return types; }
}
