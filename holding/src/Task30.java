import pets.Pet;
import pets.Pets;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Dmitriy on 20.12.2019.
 */
public class Task30 implements Collection {
    private Pet[] pets = Pets.createArray(8);

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public boolean isEmpty() {
        return pets.length==0;
    }

    @Override
    public boolean contains(Object o) {
        for(Pet e : pets) {
            if(e == o) return true;
        }
        return false;
    }

    @Override
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

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        pets = null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public static void main(String[] args) {
        Task30 t30 = new Task30();
        for(Pet p : t30.pets)
            System.out.println(p);
        System.out.println(t30.size());
        System.out.println(t30.contains(new Pet("Rat")));
    }
}
