import util.ConvertTo;
import util.CountingGenerator;
import util.Generated;
import util.RandomGenerator;

import java.util.Arrays;

import static util.Print.print;

// Тестирование вспомогательных средств заполнения
// массивов с использованием генераторов.
public class TestArrayGeneration {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = ConvertTo.primitive(Generated.array(Boolean.class, new RandomGenerator.Boolean(), size));
        print("a1 = " + Arrays.toString(a1));
        byte[] a2 = ConvertTo.primitive(Generated.array(Byte.class, new RandomGenerator.Byte(), size));
        print("a2 = " + Arrays.toString(a2));
        char[] a3 = ConvertTo.primitive(Generated.array(Character.class, new RandomGenerator.Character(), size));
        print("a3 = " + Arrays.toString(a3));
        short[] a4 = ConvertTo.primitive(Generated.array(Short.class, new RandomGenerator.Short(), size));
        print("a4 = " + Arrays.toString(a4));
        int[] a5 = ConvertTo.primitive(Generated.array(Integer.class, new RandomGenerator.Integer(), size));
        print("a5 = " + Arrays.toString(a5));
        long[] a6 = ConvertTo.primitive(Generated.array(Long.class, new RandomGenerator.Long(), size));
        print("a6 = " + Arrays.toString(a6));
        float[] a7 = ConvertTo.primitive(Generated.array(Float.class, new RandomGenerator.Float(), size));
        print("a7 = " + Arrays.toString(a7));
        double[] a8 = ConvertTo.primitive(Generated.array(Double.class, new RandomGenerator.Double(), size));
        print("a8 = " + Arrays.toString(a8));
        print("Тест с CountingGenerator");
        double[] b1 = ConvertTo.primitive(Generated.array(Double.class, new CountingGenerator.Double(), size));
        print(Arrays.toString(b1));
        try {
            print(CountingGenerator.String.class.newInstance().next());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
