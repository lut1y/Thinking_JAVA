import java.util.*;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);
        System.out.printf("flist.contains(new Apple()): %b\n", flist.contains(new Apple()));
        System.out.printf("flist.indexOf(new Apple()): %d\n", flist.indexOf(new Apple()));
    }
}
