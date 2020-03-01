/**
 * Created by Dmitriy on 26.12.2019.
 */

class NeedsCleanup {
    private static long counter = 1;
    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedsCleanup " + id + " освобожден");
    }
}

class ConstructionException extends Exception {}

class NeedsCleanup2 extends NeedsCleanup {
    public NeedsCleanup2() throws ConstructionException {}
}

public class CleanupIdiom {
    public static void main(String[] args) {
        // Part1
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            // ...
        } finally {
            nc1.dispose();
        }

        // Part2
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            //...
        } finally {
            nc3.dispose();
            nc2.dispose();
        }

        // Part3
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try{

                } finally {
                nc5.dispose();
            }
        } catch (ConstructionException e) {
            System.out.println(e);
        } finally {
                nc4.dispose();
            }
        } catch(ConstructionException e) {
            System.out.println(e);
        }
    }
}
