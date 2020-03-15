import util.Generator;
import util.RandomGenerator;

import java.util.Random;

// Заполение массива с использованием генератора
class FArrray {
    public static <T> T[] fill(T[] a, Generator<T> gen) {
        for(int i=0; i< a.length; i++)
            a[i] = gen.next();
        return a;
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FArrray.fill(new String[7], new RandomGenerator.String(10));
        for(String s : strings)
            System.out.println(s);
        Integer[] integers = FArrray.fill(new Integer[7], new RandomGenerator.Integer());
        for(int i : integers)
            System.out.println(i);
        // Автоматическая упаковка не спасет - команда не компилируется:
        // int[] b = FArrray.fill(new int[7], new RandomGenerator.Integer());

    }
}
