import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task9 {
    private Object[] items;
    private int next = 0;

    public Task9(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) i++;
        }

        @Override
        public Sequence outer() {
            return null;
        }

    }

    public Selector selector() {
        return new SequenceSelector();
    }

    void f() {
        System.out.println("Sequence.f()");
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 8; i++)
            sequence.add(Integer.toString(i));

        Selector selector = sequence.selector();

        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.outer().f();
            selector.next();

        }

        List<Object> sequence1 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            sequence1.add(Integer.toString(i));
        }
        Iterator<Object> it = sequence1.iterator();
        while(it.hasNext()) {
            Object a = it.next();
            System.out.println(a.toString());
        }
    }
}
