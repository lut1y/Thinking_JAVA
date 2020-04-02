import coffee.Coffee;
import coffee.Latte;
import coffee.Mocha;
import pets.*;
import util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static util.Print.print;

interface Addable<T> { void add(T t); }

public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for(int i=0; i<size; i++)
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for(int i=0; i<size; i++)
            addable.add(generator.next());
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;
    public void add(T t) { c.add(t); }
    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) { super.add(item); }
}

class Fill2Test {
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<Coffee>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
        for(Coffee c : carrier)
            print(c);
        print("-------------------------");
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<Coffee>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);
        for(Coffee c : coffeeQueue)
            print(c);
        print("*************************");
        List<Pet> carrier1 = new ArrayList<Pet>();
        Fill2.fill(new AddableCollectionAdapter<Pet>(carrier1), Cat.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier1), Dog.class, 2);
        for(Pet c : carrier1)
            print(c);
        print("-------------------------");
        AddableSimpleQueue<Pet> petQueue = new AddableSimpleQueue<Pet>();
        Fill2.fill(petQueue, Mouse.class, 4);
        Fill2.fill(petQueue, Manx.class, 1);
        for(Pet c : petQueue)
            print(c);

    }
}
