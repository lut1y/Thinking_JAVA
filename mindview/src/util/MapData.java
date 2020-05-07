package util;
import java.util.LinkedHashMap;

public class MapData<K, V> extends LinkedHashMap<K, V> {
    // Один генератор Pair:
    public MapData(Generator<Pair<K,V>> gen, int quantity) {
        for(int i=0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }
    // Два разных генератора:
    public MapData(Generator<K> genK, Generator<V> genV,
                   int quantity) {
        for(int i=0; i<quantity; i++)
            put(genK.next(), genV.next());
    }
    // Генератор ключа и одно значение:
    public MapData(Generator<K> genK, V value, int quantity) {
        for(int i=0; i<quantity; i++)
            put(genK.next(), value);
    }

    // Iterable и генератор значения:
    public MapData(Iterable<K> genK, Generator<V> genV) {
        for(K key: genK)
            put(key, genV.next());
    }
    // Iterable и одно значение:
    public MapData(Iterable<K> genK, V value) {
        for(K key : genK)
            put(key, value);
    }
    // Обобщенные вспомогательные методы:
    public static <K, V> MapData<K, V>
    map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData<K, V>(gen, quantity);
    }
    public static <K, V> MapData<K, V>
    map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData<K, V> (genK, genV, quantity);
    }
    public static <K, V> MapData<K, V>
    map(Generator<K> genK, V value, int quantity) {
        return new MapData<K, V> (genK, value, quantity);
    }
    public static <K, V> MapData<K, V>
    map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<K, V> (genK, genV);
    }
    public static <K, V> MapData<K, V>
    map(Iterable<K> genK, V value) {
        return new MapData<K, V> (genK, value);
    }
}
