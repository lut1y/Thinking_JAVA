package pets;

import java.util.ArrayList;
// Фасад для создания PetCreator по умолчанию.

public class Pets {
    // константа creator класса PetCreator, который содержит
    // types с литералами
    public static final PetCreator creator = new LiteralPetCreator();
    // Старый метод
    // Метод, декомпозированный от PetCreator
//    public static Pet randomPet() {
//        return creator.randomPet();
//    }

    public static Pet randomPet() {
        return PetFactories.createRandom();
    }

    // Метод, декоспозированный от PetCreator
    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }
    // Метод, декомпозированный от PetCreator
    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}