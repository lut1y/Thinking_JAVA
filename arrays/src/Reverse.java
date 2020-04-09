import util.Generated;
import java.util.Arrays;
import java.util.Collections;

import static util.Print.print;

public class Reverse {
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        print("before:");
        print(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        print("after:");
        print(Arrays.toString(a));
    }
}
