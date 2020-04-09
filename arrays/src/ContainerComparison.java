import util.Generated;
import util.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.Print.print;

class BerylluimSphere implements Comparable<BerylluimSphere> {
    private static long counter;
    private final long id = counter++;
    public long getId() { return id; }
    public String toString() { return "Sphere " + id;}

    public int compareTo(BerylluimSphere o) {
        return getId() < o.getId() ? -1 : (getId() == getId() ? 0 : 1);
    }
}

public class ContainerComparison {
    public static class GeneratorBerylluimSphere implements Generator<BerylluimSphere> {
        public BerylluimSphere next() { return new BerylluimSphere(); }
    }

    public static void main(String[] args) {
        BerylluimSphere[] spheres = new BerylluimSphere[10];
        for(int i=0; i < 5; i ++)
            spheres[i] = new BerylluimSphere();
        print(Arrays.toString(spheres));
        print(spheres[4]);

        List<BerylluimSphere> spheresList = new ArrayList<BerylluimSphere>();
        for(int i=0; i<5; i++)
            spheresList.add(new BerylluimSphere());
        print(spheresList);
        print(spheresList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        print(Arrays.toString(integers));
        print(integers[4]);

        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        print(intList);
        print(intList.get(4));
        print("Task 15");
        BerylluimSphere[] berylluimSphere = Generated.array(BerylluimSphere.class, new ContainerComparison.GeneratorBerylluimSphere(), 5);
        print(Arrays.toString(berylluimSphere));
    }
}
