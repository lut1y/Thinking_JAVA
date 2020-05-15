import util.Countries;

import java.util.*;

import static util.Print.print;

class SlowMap17<K,V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    private EntrySet entries = new EntrySet();
    public  Set<Map.Entry<K,V>> entrySet() { return entries; }

    // внутренний класс EntrySet наследующий абстрактное множество Map-сущностей
    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public int size() {
            return keys.size();
        }
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                int index = -1;
                public boolean hasNext() {
                    return index < size() - 1;
                }
                public Entry<K, V> next() {
                    int i = ++index;
                    return new MapEntry(keys.get(i), values.get(i));
                }
            };
        }
    }

    private class KeySet extends AbstractSet<K> {

        public Iterator<K> iterator() {
            return new Iterator<K>() {
                int index = -1;
                public boolean hasNext() {
                    return index < size()-1;
                }

                public K next() {
                    int i = ++index;
                    return keys.get(i);
                }

                public void remove() {
                    keys.remove(index--);
                }
            };
        }

        public int size() {
            return keys.size();
        }
    }

    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    public V put(K key, V value) {
        V oldValue = get(key);
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    public V get(Object obj) {
        if(!keys.contains(obj))
            return null;
        return values.get(keys.indexOf(obj));
    }

    public boolean equals(Object o) {
        if (o instanceof SlowMap17) {
            if(this.entrySet().equals(((SlowMap17) o).entrySet()))
                return true;
        }
        return false;
    }

    public int hashCode() {
        return this.entrySet().hashCode();
    }

    public V remove(Object obj) {
        V v = get(obj);
        int i = keys.indexOf(obj);
        keys.remove(i);
        values.remove(obj);
        return v;
    }

    public boolean isEmpty() {
        return this.entrySet().isEmpty();
    }

    public void clear() {
        keys.clear();
        values.clear();
    }

    public String toString() {
        return this.entrySet().toString();
    }

    public int size() { return keys.size(); }

    public Collection<V> values() {
        return values();
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        for(Map.Entry<? extends K, ? extends V> me : m.entrySet())
            this.put(me.getKey(), me.getValue());
    }
}

public class Task17 {
    public static void main(String[] args) {
        SlowMap17<String, String> m = new SlowMap17<String, String>();
        m.putAll(Countries.capitals(15));
        print("m: " + m);
        print("m.get(\"BURUNDI\"): " + m.get("BURUNDI"));
        print("m.entrySet(): " + m.entrySet());
        print("m.keySet(): " + m.keySet());
        print("Two different map:");
        SlowMap17<String, String> m2 = new SlowMap17<String, String>();
        print("m.equals(m2): " + m.equals(m2));
        m2.putAll(Countries.capitals(15));
        print("Maps with same entries");
        print("m.equals(m2): " + m.equals(m2));
        m.clear();
        print("After m.clear(), m.isEmpty(): " +
                m.isEmpty() + ", m = " + m);
        m2.keySet().clear();
        print("After m2.keySet().clear(), m2.isEmpty(): "
                + m2.isEmpty() + ", m2 = " + m2);
    }
}
