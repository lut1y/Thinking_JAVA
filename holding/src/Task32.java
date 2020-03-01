import pets.Pet;
import pets.Pets;

import java.util.*;

/**
 * Created by Dmitriy on 13.11.2019.
 */

public class Task32 implements Iterable<Pet> {
    protected Pet[] pets = Pets.createArray(8);

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

    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int current = pets.length-1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[current--];
                    }

                    @Override
                    public void remove() { // Не реализован
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Pet> randomized() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        Task32 t32 = new Task32();

        System.out.print("Исходник: ");
        for (Pet s: t32.pets)
            System.out.print(s + " ");
        System.out.println();

        System.out.print("Наоборот: ");
        for(Pet s : t32.reversed())
            System.out.print(s + " ");
        System.out.println();

        System.out.print("Случайный метод: ");
        for(Pet s : t32.randomized())
            System.out.print(s + " ");
        System.out.println();

    }

}
