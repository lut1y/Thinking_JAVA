package util;

/**
 * Created by Dmitriy on 29.01.2020.
 */
public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
