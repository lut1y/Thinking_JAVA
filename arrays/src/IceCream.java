// Возвращение массивов из методов.
import java.util.*;

public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = {
        "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
        "Mint Chip", "Mocha Almong Fudge", "Rum Raisin",
        "Praline Cream", "Mud Pie"
    };
    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n]; // массив строк
        boolean[] picked = new boolean[FLAVORS.length]; // массив булевских типов
        for(int i=0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            } while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }
    public static BerylluimSphere[] intSet(int n) {
        BerylluimSphere[] bs = new BerylluimSphere[n];
        for(int i=0; i<n; i++)
            bs[i] = new BerylluimSphere();
        return bs;
    }
    public static void main(String[] args) {
        for(int i=0; i<7; i++)
            System.out.println(Arrays.toString(flavorSet(3)));
        System.out.println(Arrays.toString(intSet(10)));
    }
}
