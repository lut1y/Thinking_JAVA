import util.*;
import java.util.*;
import static util.Print.print;

public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;
    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public String toString() {
        String result = "[i=" + i + ", j=" + j +"]";
        if(count++ % 3 == 0)
            result += "\n";
        return result;
    }

    public int compareTo(CompType o) {
        return (i < o.i ? -1 : (i == o.i ? 0 : 1));
    }
    private static Random rand = new Random(47);
    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            public CompType next() {
                return new CompType(rand.nextInt(100), rand.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], generator());
        print("before sorting: ");
        print(Arrays.toString(a));
        Arrays.sort(a);
        print("after: ");
        print(Arrays.toString(a));
    }
}
