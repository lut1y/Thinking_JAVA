package util;

import java.util.*;

public class CountingMapData extends AbstractMap {
    private int size;
    private static String[] chars =
            "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        this.size = size < 0 ? 0 : size;
    }

    private static class Entry implements Map.Entry<Integer, String> {
        int index;
        Entry(int index) { this.index = index; }
        public boolean equals(Object o) { return Integer.valueOf(index).equals(o); }
        public Integer getKey() { return index; }
        public String getValue() {
            return chars[index % chars.length] +
                    Integer.toString(index / chars.length);
        }
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }
    public Set<Map.Entry<Integer, String>> entrySet() {
        // LinkedHashSet сохраняет порядок инициализации:
        Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<Map.Entry<Integer, String>>();
        for(int i=0; i < size; i++)
            entries.add(new Entry(i));
        return entries;
    }
    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
}
