import java.util.Arrays;
import java.util.Comparator;

import static util.Print.print;

public class Task18 {
    public static void main(String[] args) {
        BerylluimSphere[] bs1 = new BerylluimSphere[10];
        Arrays.fill(bs1, new BerylluimSphere());
        print("bs1 = " + Arrays.toString(bs1));

        BerylluimSphere[] bs2 = new BerylluimSphere[2];
        Arrays.fill(bs2, new BerylluimSphere());
        print("bs2 = " + Arrays.toString(bs2));

        System.arraycopy(bs2,0, bs1, 3, bs2.length);
        print("bs1 = " + Arrays.toString(bs1));

        bs2[0] = new BerylluimSphere();
        System.out.println("bs2[0] = " + bs2[0]);
        print("bs1 = " + Arrays.toString(bs1));
        print("***");
        BerylluimSphere[] bsa1 = new BerylluimSphere[3];
        for(int i=0; i < bsa1.length; i++)
            bsa1[i] = new BerylluimSphere();
        System.out.println(Arrays.toString(bsa1));
        BerylluimSphere[] bsa2 = new BerylluimSphere[4];
        System.out.println(Arrays.toString(bsa2));
        System.arraycopy(bsa1, 0, bsa2, 0, bsa1.length);
        System.out.println(Arrays.toString(bsa2));
        print("***");
        print("berfore: " + Arrays.toString(bsa1));
        Arrays.sort(bsa1, Comparator.reverseOrder());
        print("after: " + Arrays.toString(bsa1));



    }
}
