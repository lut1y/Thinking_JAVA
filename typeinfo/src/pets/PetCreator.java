package pets;

import java.util.*;

public abstract class PetCreator {
    private Random rand = new Random(47);
    // Контейнер List с разными видами создаваемых объектов Pets:
    public abstract List<Class<? extends Pet>> types(); // абстрактный метод types(),
//     который на выходе будет иметь List, содержащий классы (литералы) наследуемые от Pet


    public Pet randomPet() { // Создание одного случайного объекта Pet
//        int n = rand.nextInt(types().size());
//        try {
//            return types().get(n).newInstance();
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
        return PetFactories.createRandom();
    }
    public Pet[] createArray(int size) {
        // метод createArray, создает массив размером size,
        // который заполняется случайным образом
        Pet[] result = new Pet[size];
        for(int i=0; i<size; i++)
            result[i] = randomPet();
        return result;
    }
    public ArrayList<Pet> arrayList(int size) {
        // метод arrayList, который возвращает ArrayList<Pet> c
        // компонентами подготовленными случайным образом
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
