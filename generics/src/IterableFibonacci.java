import util.Generator;

import java.util.Iterator;

// Адаптация класса Fibonacci для поддержки Iterable.
public class IterableFibonacci implements Generator<Integer>, Iterable<Integer>{
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n>0;
            }

            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }
    public Fibonacci fibonacci = new Fibonacci();

    public Integer next() {
        return fibonacci.next();
    }

    public static void main(String[] args) {
        IterableFibonacci ifib = new IterableFibonacci(18);
        Iterator<Integer> iterator = ifib.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }

}
