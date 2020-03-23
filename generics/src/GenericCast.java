import simple.List;

import java.util.ArrayList;

class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;
    private ArrayList<T> storage1;
    public FixedSizeStack() {  // int index
//        storage = new Object[index];
        storage1 = new ArrayList<T>();
    }
    public void push(T item) {
//        storage[index++] = item;
        storage1.add(item);
    }
    @SuppressWarnings("unchecked")
    public T pop() {
//        return (T) storage[--index];
        T item = storage1.get(storage1.size()-1);
        storage1.remove(storage1.size()-1);
        return (T) item;
    }
}

public class GenericCast {
    public static final int SIZE = 10;
    public static void main(String[] args) {
//        FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
        FixedSizeStack<String> strings = new FixedSizeStack<String>();
        for(String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        for(int i=0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}
