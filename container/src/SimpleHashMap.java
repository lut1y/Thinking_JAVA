import util.Countries;

import java.util.*;

// Демонстрация карты с хешированием.
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
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

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println("m.get(\"ERITREA\"): " + m.get("ERITREA"));
        System.out.println("m.entrySet(): " + m.entrySet());
    }
}
