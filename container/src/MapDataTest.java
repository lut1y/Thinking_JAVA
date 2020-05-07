import util.*;
import java.util.Iterator;

import static util.Print.print;

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() { return number < size; }
            public Integer next() { return number++; }
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }

    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        // Генератор Pair:
        print(MapData.map(new Letters(), 11));
        // Два разных генератора:
        print(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));
        // Генератор ключей и одно значение:
        print(MapData.map(new CountingGenerator.Character(), "Value", 6));
        // Iterable и одно значение:
        print(MapData.map(new Letters(), "Pop"));

    }
}
