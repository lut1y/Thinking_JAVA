import java.util.*;

/**
 * Created by 123 on 07.11.2019.
 */

class GeneratorString {
    Random rand = new Random(47);

    public String next() {
        String s="";
        for(int i=0; i<7; i++) {
            s=s+(char)(66 + rand.nextInt(25));
        }
        return s;
    }

    public List<String> arrayString(int size) {
        List<String> list = new ArrayList<String>();
        for(int i=0; i<size; i++)
            list.add(next());
        return list;
    }
}

public class Task6 {
    public static void main(String[] args) {
        GeneratorString gi = new GeneratorString();

        List<String> pets = gi.arrayString(7);
        System.out.println("1: " + pets);
        String h = gi.next();
        pets.add(h); // С автоматическим изменением размера
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains(h));
        pets.remove(h); // Удаление заданного объекта
        String p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));
        String cymric = gi.next();
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.remove(cymric));
//         Удаление заданного объекта:
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
        pets.add(3, gi.next()); // Вставка по индексу
        System.out.println("9: " + pets);
        List<String> sub = pets.subList(1,4);
        System.out.println("Частный список: " + sub);
        System.out.println("10: " + pets.containsAll(sub));
        Collections.sort(sub); // Сортировка на месте
        System.out.println("После сортировки: " + sub);
//         Для constrainsAll() порядок не важен:
        System.out.println("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, new Random(47)); // Перемешивание
        System.out.println("После перемешивания: " + sub);
        System.out.println("12: " + pets.containsAll(sub));
        List<String> copy = new ArrayList<String>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<String>(pets); // Копирование
        copy.remove(2); // Удаление по индексу
        System.out.println("14: " + copy);
        copy.removeAll(sub); // Удаление заданных объектов
        System.out.println("15: " + copy);
        copy.set(1, gi.next()); // Замена элемента
        System.out.println("16: " + copy);
        copy.addAll(2, sub); // Вставка списка в середину
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty());
        pets.clear(); // Удаление всех элементов
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
        pets.addAll(gi.arrayString(4));
        System.out.println("21: " + pets);
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
//        String[] pa = pets.toArray();
//        System.out.println("23: " + pa[3].id());
    }
}
