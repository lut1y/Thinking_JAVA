import util.ConvertTo;
import util.Generated;
import util.Generator;
import util.RandomGenerator;

import java.util.Arrays;

import static util.Print.print;

public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
        Arrays.sort(a);
        print("Sorted array: " + Arrays.toString(a));
        while(true) {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if(location >= 0) {
                print("Location of " + r + " is " + location +
                        ", a[" + location + "] = " + a[location]);
                break;
            }
        }

    }
}
