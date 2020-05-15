import java.util.*;

import static util.Print.print;
import static util.Print.printnb;

public class SlowSet<E> implements Set<E> {
    private List<E> elements = new ArrayList<E>();

    public Iterator iterator() {
        return elements.iterator();
    }

    public Object[] toArray() {
        return elements.toArray();
    }

    public <E> E[] toArray(E[] a) {
        return elements.toArray(a);
    }

    public boolean add(E e) {
        if(elements.contains(e)) return false;
        elements.add(e);
        return true;
    }

    public boolean remove(Object o) {
        return elements.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        int count = 0;
        for(Object o : c)
            if(elements.contains(o)) count++;
        if(count == c.size()) return true;
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return elements.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        int n = elements.size();
        for(int i=0; i < elements.size(); i++) {
            E e = elements.get(i);
            if(!c.contains(e)) elements.remove(e);
        }
        if(n != c.size()) return true;
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        int n = elements.size();
        for(Object o : c) { if(!c.contains(o)) elements.remove(o); }
        if(n != c.size()) return true;
        return false;
    }

    public void clear() {
        elements.clear();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.size()==0;
    }

    public boolean contains(Object o) {
        return elements.contains(o);
    }

    public String toString() {
        return elements.toString();
    }

    public static void main(String[] args) {
        SlowSet<String> ss = new SlowSet<String>();
        ss.add("hi");
        print(ss);
        ss.add("there");
        print(ss);
        List<String> list = Arrays.asList("you", "cutie", "pie");
        ss.addAll(list);
        print(ss);
        print("ss.size(): " + ss.size());
        print("ss.contains(\"you\"): " + ss.contains("you"));
        print("ss.contains(\"me\"): " + ss.contains("me"));
        print("ss.containsAll(list): " + ss.containsAll(list));
        SlowSet<String> ss2 = new SlowSet<String>();
        print("ss2 = " + ss2);
        print("ss.containsAll(ss2): " + ss.containsAll(ss2));
        print("ss2.containAll(ss): " + ss2.containsAll(ss));
        ss2.add("you");
        ss2.add("cutie");
        ss.removeAll(ss2);
        print("ss = " + ss);
        print("ss.hashCode() = " + ss.hashCode());
        List<String> list2 = Arrays.asList("hi", "there", "pie");
        ss2.remove("you");
        print(ss2);
        print("ss2.isEmpty(): " + ss2.isEmpty());
        ss2.clear();
        print("ss2.isEmpty(): " + ss2.isEmpty());
        ss2.addAll(list2);
        print("ss2 = " + ss2);
        print("ss.equals(ss2): " + ss.equals(ss2));
        String[] sa = new String[3];
        print("ss.toArray(sa): " + ss.toArray(sa));
        for(int i = 0; i < sa.length; i++) printnb(sa[i] + " " );
    }
}
