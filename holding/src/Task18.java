import pets.Pet;
import pets.Pets;

import java.util.*;

/**
 * Created by Dmitriy on 12.11.2019.
 */

public class Task18 {
    public static Map<Integer, Pet> idPet = new HashMap<Integer, Pet>();
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.arrayList(8);
        for(int i=0; i<8; i++)
            idPet.put(rand.nextInt(50), pets.get(i));
        System.out.println(idPet);

        Map<Integer, Pet> idPetSort = new TreeMap<Integer, Pet>();
        for (Integer i : idPet.keySet()) {
            idPetSort.put(i, idPet.get(i));
        }
        System.out.println(idPetSort);
    }
}
