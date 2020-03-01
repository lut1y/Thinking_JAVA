import pets.Pet;
import pets.Pets;

import java.util.Iterator;

/**
 * Created by Dmitriy on 13.11.2019.
 */

class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence {
        public Iterator<Pet> iterator() {
            return new Iterator<Pet>() {
                private int index = 0;
                public boolean hasNext() {
                    return index < pets.length;
                }

                public Pet next() {
                    return pets[index++];
                }

                public void remove() { // Not implemented
                    throw new UnsupportedOperationException();
                }
            };
        }
        public static void main(String[] args) {
            NonCollectionSequence nc = new NonCollectionSequence();
            InterfaceVsIterator.display(nc.iterator());
        }

}
