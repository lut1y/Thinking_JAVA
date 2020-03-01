// Хранение последовательности Object.

import java.util.ArrayList;
import java.util.List;

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class GenericSequence<E> {
    private List<E> items = new ArrayList<E>(); // массив объектов items
    private int next = 0; // счетчик next
    public GenericSequence(List<E> list) { items = list; } // конструктор для создания массива items
    public void add(E x) {  // функция добавления в массив
        items.add(x);
    }
    private class SequenceSelector implements Selector {  // внутренний класс реализующий Selector
        private int i = 0;
        public boolean end() { return i == items.size(); }
        public Object current() { return items.get(i); }
        public void next() { if(i < items.size()) i++; }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        GenericSequence<String> sequence = new GenericSequence<String>(list);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}