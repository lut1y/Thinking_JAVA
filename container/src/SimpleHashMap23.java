import util.CountingGenerator;
import util.Countries;

import java.util.*;

import static util.Print.print;

public class SimpleHashMap23<K,V> implements Map<K,V> {
    // В качестве размера хеш-таблицы следует выбирать
    // простое число, чтобы обеспечить равномерность распределения:
    static final int SIZE = 997;
    // Физический массив обобщений создать нельзя, но можно
    // прийти к нему через восходящее преобразование:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE]; // buckets = узловые группы (ячейки хэш-таблицы)

    /*
    LinkedList<MapEntry<K,V>>[]:
    1. LinkedList<MapEntry<K,V>>            :   ->  MapEntry<K,V>   ->  K Key, V value
    2. LinkedList<MapEntry<K,V>>            :   ->  MapEntry<K,V>   ->  K Key, V value
    ...
    SIZE[997]. LinkedList<MapEntry<K,V>>    :   ->  MapEntry<K,V>   ->  K Key, V value
    */

    public int size() {
        // Считаем общее количество EntryMap в хэш-таблице
        int result = 0;
        for(LinkedList bucket : buckets)
            if(bucket != null) result += bucket.size();
        return result;
    }

    // Три метода для помощи при работе с итерацией EntrySet.iterator():
    private int firstNonEmptyBucket() {
        // функция возвращает первый не пустой номер записи в buckets
        if(buckets.length < 1) return -1;
        for(int i=0; i<buckets.length; i++)
            if(buckets[i] !=null) return i;
        return -1;
    }
    private int start(int i) {
        // функция возвращает количество MapEntry, начиная
        // c первой ненулевой записи массива buckets до buckets(i)
        // или первой нулевой записи массива
        int first = this.firstNonEmptyBucket();
        if(i < first) return -1;
        if(i == first) return 0;
        int result = 0;
        for(int j = first; j < i; j++)
            if(buckets[j] != null) result += buckets[j].size();
        return result;
    }
    private int end(int i) {
        // функция возвращает количество MapEntry, начиная
        // c первой ненулевой записи массива buckets до buckets(i),
        // исключая нулевые записи массива
        int first = this.firstNonEmptyBucket();
        if(i < first) return -1;
        return start(i) + (buckets[i] == null ? 0 : buckets[i].size());
    }

    private EntrySet entries = new EntrySet(); // Множество MapEntry
    private KeySet keys = new KeySet(); // Множество ключей
    public Set<Map.Entry<K,V>> entrySet() { return entries; }
    public Set<K> keySet() { return keys; }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if(!found) buckets[index].add(pair);
        return oldValue;
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        for(Map.Entry<? extends K, ? extends V> me : m.entrySet())
            this.put(me.getKey(), me.getValue());
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public void clear() {
        for(LinkedList<MapEntry<K,V>> bucket : buckets)
            if(bucket != null) bucket.clear();
    }

    public boolean containsKey(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return false;
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key)) return true;
        return false;
    }

    public boolean containsValue(Object value) {
        for(LinkedList<MapEntry<K,V>> bucket : buckets)
            if(bucket != null)
                for(MapEntry<K,V> iPair : bucket)
                   if(iPair.getValue().equals(value))
                       return true;
        return false;
    }

    public Collection<V> values() {
        HashSet<V> vals = new HashSet<V>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket != null)
                for(MapEntry<K,V> iPair : bucket)
                    vals.add(iPair.getValue());
        }
        return vals;
    }

    public boolean equals(Object o) {
        if(o instanceof SimpleHashMap23) {
            if(this.entrySet().equals(((SimpleHashMap23) o).entrySet()))
                return true;
        }
        return false;
    }

    public int hashCode() {
        return this.entrySet().hashCode();
    }

    public V remove(Object key) {
        V v = null;
        if(this.get(key) != null) {
            int index = Math.abs(key.hashCode()) % SIZE;
            for(MapEntry<K,V> iPair : buckets[index])
                if(iPair.getKey().equals(key)) {
                    v = iPair.getValue();
                    int i = buckets[index].indexOf(iPair);
                    buckets[index].remove(i);
                    break;
                }
        }
        return v;
    }

    // Описание классов
    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public int size() { return SimpleHashMap23.this.size(); }
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private int index = -1;
                public boolean hasNext() {
                    return index < size()-1;
                }

                public Map.Entry<K, V> next() {
                    int i = ++index;
                    for(int j=0; j < SIZE; j++) {
                        if((start(j) <= index) && (index < end(j)))
                            return new MapEntry(buckets[j].get(index-start(j)).getKey(),
                                    buckets[j].get(index-start(j)).getValue());
                    }
                    return null;
                }

                public void remove() {
                    for(int j=0; j<SIZE; j++)
                        if(start(j) <= index && index < end(j))
                            buckets[j].remove(index-start(j));
                    index--;
                }
            };
        }
    }

    private class KeySet extends AbstractSet<K> {
        // Класс, содержащий все Key от MapEntry
        public int size() { return SimpleHashMap23.this.size(); }
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                private int index = -1;
                public boolean hasNext() {
                    return index < size()-1;
                }

                public K next() {
                    int i = ++index;
                    for(int j=0; j<SIZE; j++) {
                        if((start(j) <= index) && (index < end(j)))
                            // выбирается такой индекс записи в таблице,
                            // при котором индекс множества ключей должен быть
                            // не мешьше "текущего" числа MapEntry и меньше общего числа MapEntry
                            return buckets[j].get(index-start(j)).getKey(); // возвращем ключ нужной записи
                            // в таблице хэш-таблице и в нужной позиции
                    }
                    return null;
                }

                public void remove() {
                    for(int j=0; j<SIZE; j++)
                        if(start(j) <= index && index < end(j))
                            buckets[j].remove(index-start(j));
                    index--;
                }
            };
        }
    }

    public String toString() {
        return this.entrySet().toString();
    }

    public static void main(String[] args) {
        SimpleHashMap23<String, String> map =
                new SimpleHashMap23<String, String>();
        map.putAll(Countries.capitals(3));
        print("map = " + map);
        print("map.entrySet(): " + map.entrySet());
        print("map.keySet(): " + map.keySet());
        print("map.value(): " + map.values());
        print("map.isEmpty(): " + map.isEmpty());
        print("map.containsKey(\"ALGERIA\"): " + map.containsKey("ALGERIA"));
        print("map.containsValue(\"Algiers\"): " + map.containsValue("Algiers"));
        print("map.get(\"ALGERIA\"): " + map.get("ALGERIA"));
        print("map.remove(\"ALGERIA\"): " + map.remove("ALGERIA"));
        print("After map.remove(\"ALGERIA\"), map.containsKey(\"ALGERIA\"): " +
                map.containsKey("ALGERIA"));
        print(" and map.get(\"ALGERIA\"): " + map.get("ALGERIA"));
        print(" and map: = " + map);
        map.clear();
        print("After map.clear(), map = " + map);
        print(" and map.isEmpty(): " + map.isEmpty());
        map.putAll(Countries.capitals(3));
        print("After map.putAll(Countries.capitals(3)), map = " + map);
        SimpleHashMap23<String,String> map2 =
                new SimpleHashMap23<String,String>();
        map2.putAll(Countries.capitals(4));
        print("After map2.putAll(Countries.capitals(4)), map2 = " + map2);
        print(" and map.equals(map2): " + map.equals(map2));
        map2.remove("BOTSWANA");
        print("After map2.remove(\"BOTSWANT\"), map.equals(map2): " + map.equals(map2));
        map.entrySet().clear();
        print("After map.entrySet().clear, map = " + map);
        map.putAll(Countries.capitals(3));
        print("After map.putAll(Countries.capitals(3)), map = " + map);
        map.keySet().clear();
        print("After map.keySet().clear(), map = " + map);
    }
}
