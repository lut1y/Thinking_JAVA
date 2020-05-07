import util.CollectionData;
import util.RandomGenerator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import static util.Print.print;

class SortedSet10<E> extends LinkedList<E> {
    public boolean add(E e) {
        if(!this.contains(e)) {
            Iterator<E> it = this.iterator();
            int index = 0;
            while (it.hasNext()) {
                if(compare(it.next(), e) < 1)
                    index++;
            }
            this.add(index, e);
            return true;
        }
        return false;
    }

    int compare(E e1, E e2) {
        int c = e1.hashCode() - e2.hashCode();
        return c < 0 ? -1 : (c==0 ? 0 : 1);
    }
}

class T {}

public class Task10 {
    public static void main(String[] args) {
        SortedSet10<T> ss = new SortedSet10<T>();
        ss.add(new T());
        ss.add(new T());
        ss.add(new T());
        ss.add(new T());
        print(ss);
        SortedSet10<Integer> ss2 = new SortedSet10<Integer>();
        ss2.add(6);
        ss2.add(8);
        ss2.add(2);
        ss2.add(4);
        print(ss2);
    }
}
