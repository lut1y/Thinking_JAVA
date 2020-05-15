import util.Countries;
import java.util.*;

// Демонстрация карты с хешированием.
public class Task20<K,V> extends AbstractMap<K,V> {
    // В качестве размера хеш-таблицы следует выбирать
    // простое число, чтобы обеспечить равномерность распределения:
    static final int SIZE = 997;
    // Физический массив обобщений создать нельзя, но можно
    // прийти к нему через восходящее преобразование:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE]; // buckets = узловые группы (ячейки хэш-таблицы)

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;            // index = остаток от деления хэша на SIZE
        if(buckets[index] == null)                              // если в массиве место свободно, то
            buckets[index] = new LinkedList<MapEntry<K,V>>();   // отправляем туда новый LinkedList
        LinkedList<MapEntry<K,V>> bucket = buckets[index];      // работаем с bucket как с отдельным LinkedList
        MapEntry<K,V> pair = new MapEntry<K,V>(key, value);     // создаем новую MapEntry
        boolean found = false;                                  // результат поиска по умолчанию false
        ListIterator<MapEntry<K,V>> it = bucket.listIterator(); // определяем итератор
        while (it.hasNext()) {
            MapEntry<K,V> iPair = it.next();                    //
            if(iPair.getKey().equals(key)) {                    // если найден в bucket-листе ключ
                oldValue = iPair.getValue();                    // тогда производим замену
                it.set(pair);                                   // Заменяем старое значение новым
                found = true;                                   // статус поиска true
                System.out.println("We have a collision: key=" +
                        iPair.getKey() + ", old value=" + iPair + ", new value=" + pair);
                break;
            }
        }
        if(!found)
            buckets[index].add(pair);                           // если ключ не найде, добавляем в список значение
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        // Получаем все значения MapEntry из LinkedList<>[] buckets
        Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket==null) continue;
            for (MapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    // Три метода для помощи в работе с EntrySet.iterator():
    private int firstNonEmptyBucket() {
        // Находим первый ненулевой index в массиве buckets
        if(buckets.length < 1) return -1;
        for(int j=0; j < buckets.length; j++)
            if(buckets[j] != null) return j;
        return -1;
    }
    private int start(int i) {
        // функция нахождения числа записей LinkedList
        // c начала до i
        int first = this.firstNonEmptyBucket();
        if(i < first) return -1;
        if(i == first) return 0;
        int result = 0;
        for(int j = first; j < i; j++)
            if(buckets[j] != null) result += buckets[j].size();
        return result;
    }
    private int end(int i) {
        // функция нахождения числа записей c начала до i + i-е List'ы
        int first = this.firstNonEmptyBucket();
        if(i < first) return -1;
        return start(i) + ((buckets[i] == null) ? 0 : buckets[i].size());
    }

    public void clear() {
        for(LinkedList<MapEntry<K,V>> bucket : buckets)
            if(bucket != null)
                bucket.clear();
    }

    public V remove(Object key) {
        V v = null;
        if(this.get(key) != null) {
            int index = Math.abs(key.hashCode()) % SIZE;
            for (MapEntry<K, V> iPair : buckets[index])
                if (iPair.getKey().equals(key)) {
                    v = iPair.getValue();
                    buckets[index].remove(iPair);
                    break;
                }
        }
        return v;
    }

    public int size() {
        int result = 0;
        for(LinkedList bucket : buckets)
            if(bucket != null) result += bucket.size();
        return result;
    }

    private EntrySet entries = new EntrySet();
    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
    // Множество Map.Entry
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                int index = -1;
                public boolean hasNext() {
                    return index < size()-1;
                }

                public Entry<K, V> next() {
                    int i = ++index;
                    for(int j=0; j<SIZE; j++) {
                        if((start(j) <= index) && (index < end(j)))
                            return new MapEntry(buckets[j].get(index - start(j)).getKey(),
                                    buckets[j].get(index - start(j)).getValue());
                    }
                    return null;
                }

                public void remove() {
                    for(int j=0; j < SIZE; j++)
                        if(start(j) <= index && index < end(j))
                            buckets[j].remove(index - start(j));
                        index--;
                }
            };
        }

        public int size() {
            return Task20.this.size();
        }
    }
    private KeySet keys = new KeySet();
    private class KeySet extends AbstractSet<K> {
    // Множество ключей
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                int index = -1;
                public boolean hasNext() {
                    return index < size()-1;
                }

                public K next() {
                    int i = ++index;
                    for(int j=0; j < SIZE; j++)
                        if((start(j) <= index) && (index < end(j)))
                            return buckets[j].get(index-start(j)).getKey();
                    return null;
                }

                public void remove() {
                    for(int j=0; j < SIZE; j++)
                        if(start(j) <= index && index < end(j))
                            buckets[j].remove(index-start(j));
                    index--;
                }
            };
        }

        public int size() {
            return Task20.this.size();
        }
    }


    public boolean isEmpty() {
        return this.size()==0;
    }

    public boolean containsKey(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return false;
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
                return true;
        return false;
    }

    public boolean containsValue(Object value) {
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket != null)
                for(MapEntry<K,V> iPair : bucket)
                    if(iPair.getValue().equals(value))
                        return true;
        }
        return false;
    }

    public int hashCode() {
        return this.entrySet().hashCode();
    }

    public static void main(String[] args) {
        Task20<String, String> m = new Task20<String, String>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println("m.get(\"ERITREA\"): " + m.get("ERITREA"));
        System.out.println("m.entrySet(): " + m.entrySet());
        m.put("ANGOLA", "Луанда");
        System.out.println(m);
        System.out.println("m.remove(\"ANGOLA\"): " + m.remove("ANGOLA"));
        System.out.println(m);
        System.out.println("m.containsKey(\"EGYPT\"): " + m.containsKey("EGYPT"));
        System.out.println("m.containsValue(\"Porto-Novo\"): " + m.containsValue("Porto-Novo"));
        m.clear();
        System.out.println(m);
        System.out.println("m.isEmpty(): " + m.isEmpty());
    }
}
