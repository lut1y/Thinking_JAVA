package pets;

import factory.Factory;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Dmitriy on 08.11.2019.
 */
// Использование литералов class.
public class LiteralPetCreator extends PetCreator {
    // Блок try не нужен.
    @SuppressWarnings("unchecked")
    // константа общего доступа, содержащая список классов
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class,
            Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
            Cymric.class, Rat.class, Mouse.class, Hamster.class, Gerbil.class));

    // Типы, которые должны создаваться случайным образом:
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    // реализация абстрактного метода класса PetCreator
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
