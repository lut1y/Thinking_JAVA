import pets.Pet;
import pets.Pets;

import java.util.List;

/**
 * Created by Dmitriy on 11.11.2019.
 */
public class ListIterator {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        java.util.ListIterator<Pet> it = pets.listIterator();
        while(it.hasNext())
            System.out.print(it.next() + ", " + it.nextIndex() +
                ", " + it.previousIndex() + "; ");
        System.out.println();

        System.out.println(pets);
        it = pets.listIterator(3);
        while(it.hasNext()) {
            it.next();
            it.set(Pets.randomPet());
        }
        System.out.println(pets);
    }
}


