import pets.LiteralPetCreator;
import pets.Pet;
import pets.Pets;
import util.MapData;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Dmitriy on 28.01.2020.
 */
// Избавляемся от instanceof
public class PetCount3 {
    // Наследуем класс LinkedHashMap
    static class PetCounter
    extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            // Создаем LinkedHashMap, в котором ключи - это литералы
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }
        public void count(Pet pet) {
            // Class.isInstance() избавляет от цепочки instanceof:
            for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet())
                // isInstance - сущность является экземплятом одного класса
                if(pair.getKey().isInstance(pet))
                    put(pair.getKey(), pair.getValue() + 1);
        }
        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length()-2, result.length());
            result.append("}");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        PetCounter petCount = new PetCounter();
        // Создаем массив Pets размером 20
        for(Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            petCount.count(pet);
        }
        System.out.println();
        System.out.println(petCount);
    }
}
