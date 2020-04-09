import java.util.Arrays;

public class MultidimensionalObjectArray {
    public static void main(String[] args) {
        BerylluimSphere[][] spheres = {
                { new BerylluimSphere(), new BerylluimSphere() },
                { new BerylluimSphere(), new BerylluimSphere(),
                new BerylluimSphere(), new BerylluimSphere() },
                { new BerylluimSphere(), new BerylluimSphere(),
                new BerylluimSphere(), new BerylluimSphere(),
                new BerylluimSphere(), new BerylluimSphere(),
                new BerylluimSphere(), new BerylluimSphere() },
        };
        System.out.println(Arrays.deepToString(spheres));
    }
}
