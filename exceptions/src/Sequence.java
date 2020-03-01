/**
 * Created by Dmitriy on 24.12.2019.
 */

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

    public static void main(String[] args) throws Exception {
        Sequence sequence = new Sequence(10);
        for(int i=0; i < 12; i ++) {
            if(i<10) {
                sequence.add(Integer.toString(i));
            } else {
                throw new Exception("Слишком большое число!");
            }
        }

        Selector selector = sequence.selector();

        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.outer().f();
            selector.next();

        }
    }


}