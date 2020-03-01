import java.util.ArrayList;

/**
 * Created by 123 on 01.11.2019.
 */
// Хранение последовательности Object.

interface Selector {
    boolean end();
    Object current();
    void next();
    Sequence outer();
}

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
        public Sequence outer() { return Sequence.this; }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    void f(){
        System.out.println("Sequence.f()");
    }

    public static void main(String[] args) {
        ArrayList<Object> sequence = new ArrayList<Object>();
        for(int i=0; i < 10; i ++) {
            sequence.add(Integer.toString(i));
        }

//        Selector selector = sequence.selector();
//
//        while(!selector.end()) {
//            System.out.print(selector.current() + " ");
//            selector.outer().f();
//            selector.next();
        for(Object e : sequence)
            System.out.print(e + " ");


    }


}
