import util.ConvertTo;
import util.CountingGenerator;
import util.Generated;
import util.RandomGenerator;

import java.util.Arrays;

public class PrimitiveConversionDemonstration {
    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new RandomGenerator.Integer(), 15);
        int b[] = ConvertTo.primitive(a);
        System.out.println(Arrays.toString(a));
        boolean[] c = ConvertTo.primitive(Generated.array(Boolean.class, new RandomGenerator.Boolean(), 7));
        System.out.println(Arrays.toString(c));
    }
}
