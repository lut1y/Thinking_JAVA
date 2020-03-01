import pets.Pet;
import pets.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Created by Dmitriy on 13.11.2019.
 */
public class CollectionSequence extends AbstractCollection {
    private Pet[] pets = Pets.createArray(8);
    public int size() { return pets.length; }

    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            public boolean hasNext() {
                return index < pets.length;
            }

            public Pet next() {
                return pets[index++];
            }

            public void remove() { // Не реализован
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());

    }
}
