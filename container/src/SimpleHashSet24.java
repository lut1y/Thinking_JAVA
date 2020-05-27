import java.util.*;

import static util.Print.print;
import static util.Print.printnb;

public class SimpleHashSet24<E> implements Set<E> {

    static final int SIZE = 997;
    LinkedList<E>[] buckets = new LinkedList[SIZE];

    public int size() {
        int result = 0;
        for(LinkedList<E> bucket : buckets)
            if(bucket != null) result += bucket.size();
        return result;
    }

    public boolean add(E e) {
        if(this.contains(e)) return false;
        int index = Math.abs(e.hashCode()) % SIZE;
        if(buckets[index] == null)
            buckets[index] = new LinkedList<E>();
        buckets[index].add(e);
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        int start = this.size();
        for(E e : c)
            this.add(e);
        return (this.size()>start);     // проверяем добавилось ли что-нибудь
    }

    public void clear() {
        for(LinkedList<E> bucket : buckets)
            if(bucket != null)
                bucket.clear();
    }

    public boolean contains(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if(buckets[index] == null) return false;
        for(E e : buckets[index])
            if(e.equals(o)) return true;
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        int count = 0;
        for(Object obj : c)
            if(this.contains(obj)) count++;
        if(count == c.size()) return true;
        return false;
    }

    public boolean equals(Object o) {
        if(o instanceof SimpleHashSet24) {
            if(this.size() == ((SimpleHashSet24) o).size()) {
                int count = 0;
                Iterator it = ((SimpleHashSet24) o).iterator();
                while (it.hasNext())
                    if(this.contains(it.next())) count++;
                if(this.size() == count) return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int result = 0;
        for(LinkedList<E> bucket : buckets)
            if(bucket != null)
                for(E e : bucket)
                    if(e != null) result += e.hashCode();
        return result;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    // Три метода для работы с SimpleHashSet24.iterator:
    private int firstNonEmptyBucket() {
        if(buckets.length < 1) return -1;
        for(int j=0; j<buckets.length; j++)
            if(buckets[j] != null) return j;
        return -1;
    }
    private int start(int i) {
        int first = this.firstNonEmptyBucket();
        if(i < first) return -1;
        if(i == first) return 0;
        int result = 0;
        for(int j=first; j<i; j++)
            if(buckets[j] != null) result += buckets[j].size();
        return result;
    }
    private int end(int i) {
        int first = this.firstNonEmptyBucket();
        if (i < first) return -1;
        return start(i) + ((buckets[i] != null) ? buckets[i].size() : 0);
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = -1;
            public boolean hasNext() {
                return index < SimpleHashSet24.this.size()-1;
            }

            public E next() {
                int i = ++index;
                for(int j=0; j<SIZE; j++)
                    if((start(j)) <= index && (index < end(j)))
                        // возвращаем внутренний "номер" записи в LinkedList
                        return buckets[j].get(index - start(j));
                return null;
            }

            public void remove() {
                int i = ++index;
                for(int j=0; j<SIZE; j++)
                    if((start(j)) <= index && (index < end(j)))
                        buckets[j].remove(index-start(j));
                index--;
            }
        };
    }

    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if(buckets[index] == null) return false;
        for(E e : buckets[index])
            if(e.equals(o)) {
                buckets[index].remove(e);
                return true;
            }
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        int n = this.size();
        for(Object obj : c) this.remove(obj);
        if(n != this.size()) return true;
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        int n = this.size();
        for(LinkedList<E> bucket : buckets)
            if(bucket != null)
                for (E e : bucket)
                    if(!(c.contains(e))) this.remove(e);
        if(n != this.size()) return true;
        return false;
    }

    public Object[] toArray() {
        Object[] result = new Object[this.size()];
        Iterator it = this.iterator();
        for(int i=0; i < this.size(); i++)
            result[i] = it.next();
        return result;
    }

    public <T> T[] toArray(T[] a) {
        Iterator<E> it = this.iterator();
        for(int i=0; i<this.size(); i++) {
            E x = it.next();
            a[i] = (T) x;
        }
        return a;
    }

    public String toString() {
        if(this.size() == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (LinkedList<E> bucket : buckets)
            if(bucket != null)
                for(E e : bucket)
                    sb.append(String.valueOf(e) + " ");
        sb.replace(sb.length()-1,sb.length(), "]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SimpleHashSet24<String> shs = new SimpleHashSet24<String>();
        print("New empty SimpleHashSet24, shs = " + shs);
        shs.add("hi");
        shs.add("there");
        print("After shs.add(\"hi\") and shs.add(\"there\"), shs = " + shs);
        List<String> list = Arrays.asList("you", "cutie", "pie");
        shs.addAll(list);
        print("After shs.addAll(list) (you, cutie, pie), shs = " + shs);
        print("shs.size() = " + shs.size());
        print("shs.contains(\"you\"): " + shs.contains("you"));
        print("shs.contains(\"me\"): " + shs.contains("me"));
        print("shs.containsAll(list): " + shs.containsAll(list));
        SimpleHashSet24<String> shs2 = new SimpleHashSet24<String>();
        print("New empty shs2 = " + shs2);
        print("shs.containsAll(list): " + shs.containsAll(list));
        print("shs2.containAll(list): " + shs2.containsAll(list));
        print("shs.containsAll(shs2): " + shs.containsAll(shs2));
        print("shs2.containAll(shs2): " + shs2.containsAll(shs2));
        shs2.add("you");
        shs2.add("cutie");
        print("After shs2.add(\"you\"), shs2.add(\"cutie\"), shs2 = " + shs2);
        shs.removeAll(shs2);
        print("After shs.removeAll(shs2), shs = " + shs);
        print("shs.hashCode() = " + shs.hashCode());
        print("shs2 = " + shs2);
        print("shs2.isEmpty(): " + shs2.isEmpty());
        shs2.clear();
        print("After shs2.clear(), shs2.isEmpty(): " + shs2.isEmpty());
        List<String> list2 = Arrays.asList("hi", "there", "pie");
        shs2.addAll(list2);
        print("After shs2.addAll(list2) (hi, there, pie), shs2 = " + shs2);
        print("shs.equals(shs2): " + shs.equals(shs2));
        String[] sa = new String[3];
        shs.toArray(sa);
        printnb("After String[] sa = new String[3], shs.toArray(sa), sa holds: ");
        for(int i = 0; i < sa.length; i++) printnb(sa[i] + " " );
    }
}
