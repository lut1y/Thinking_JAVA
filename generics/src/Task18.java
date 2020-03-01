import util.Generator;

import java.util.*;

class BigFish {
    private static long counter = 1;
    private final long id = counter++;
    public BigFish() {}
    public String toString() {
        return "BigFish " + id;
    }
    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}

class LittleFish {
    private static long counter = 1;
    private final long id = counter++;
    public LittleFish() {}
    public String toString() {
        return "LittleFish " + id;
    }
    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }
}

public class Task18 {
    public static void eat(LittleFish lf, BigFish bf) {
        System.out.println("In Ocean " + bf + " eat " + lf);
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<LittleFish> littleFishes = new LinkedList<LittleFish>();
        Generators.fill(littleFishes, LittleFish.generator(), 15);
        List<BigFish> bigFishes = new ArrayList<BigFish>();
        Generators.fill(bigFishes, BigFish.generator(), 15);
        for (LittleFish littleFish : littleFishes) eat(littleFish, bigFishes.get(rand.nextInt(bigFishes.size())));
    }
}
