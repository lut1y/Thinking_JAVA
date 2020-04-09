import java.util.Arrays;
import static util.Print.print;
import static util.Print.printnb;

public class ArrayOptions {
    private static void printInLine(BerylluimSphere[] bs) {
        for (BerylluimSphere b : bs)
            printnb(b + " ");
    }

    public static void main(String[] args) {
        BerylluimSphere[] a;
        BerylluimSphere[] b = new BerylluimSphere[5];
        print("b: " + Arrays.toString(b));
        BerylluimSphere[] c = new BerylluimSphere[4];
        for(int i =0; i < c.length; i++)
            c[i] = new BerylluimSphere();
        BerylluimSphere[] d = { new BerylluimSphere(), new BerylluimSphere(), new BerylluimSphere() };
        a = new BerylluimSphere[] { new BerylluimSphere(), new BerylluimSphere(), new BerylluimSphere()};
        print("a.length: " + a.length);
        print("b.length: " + b.length);
        print("c.length: " + c.length);
        print("d.length: " + d.length);
        a = d;
        print("a.length = " + a.length);

        int[] e;
        int[] f = new int[5];
        print("f: " + Arrays.toString(f));
        int g[] = new int[4];
        for(int i=0; i < g.length; i++)
            g[i] = i*i;
        int[] h = {11, 47, 93};
        print("f.length = " + f.length);
        print("g.length = " + g.length);
        print("h.length = " + h.length);
        e = h;
        print("e.length = " + e.length);
        e = new int[]{1,2};
        print("e.length = " + e.length);

        printInLine(new BerylluimSphere[]{new BerylluimSphere(), new BerylluimSphere()});
    }
}
