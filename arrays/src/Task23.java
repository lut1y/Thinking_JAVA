import util.Generated;
import util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

public class Task23 {
    public static void main(String[] args) {
        Integer[] integers = Generated.array(new Integer[10], new RandomGenerator.Integer());
        System.out.println("Before: " + Arrays.toString(integers));
        Arrays.sort(integers, Collections.reverseOrder());
        System.out.println("Before: " + Arrays.toString(integers));
    }
}
