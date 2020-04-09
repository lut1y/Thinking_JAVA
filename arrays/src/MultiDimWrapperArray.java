import java.util.Arrays;

// Многомерные массивы объектов-оберток.
public class MultiDimWrapperArray {
    public static void main(String[] args) {
        Integer[][] a1 = { // Автоматическая упаковка
                {1, 2, 3, },
                {4, 5, 6, },
        };
        Double[][][] a2 = { // Автоматическая упаковка
                {{1.1, 2.2}, {3.3, 4.4} },
                {{5.5, 6.6}, {7.7, 8.8} },
                {{9.9, 1.2}, {2.3, 3.4} },
        };
        String[][] a3 = {
                {"The", "Quick", "Sly", "Fox"},
                {"Jumped", "Over"},
                {"The", "Lazy", "Brown", "Dog", "and", "friend" },
        };
        System.out.println("a1: " + Arrays.deepToString(a1));
        System.out.println("a1: " + Arrays.deepToString(a2));
        System.out.println("a1: " + Arrays.deepToString(a3));
    }
}
