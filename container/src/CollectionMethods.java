// Операции, которые могут выполняться
// со всеми разновидностями Collection.
import util.Countries;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static util.Print.print;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        print(c);
        // Создание массива на базе List:
        Object[] array = c.toArray();
        // Создание массива String на базе List:
        String[] str = c.toArray(new String[0]);
        // Поиск наибольшего и наимнеьшего элементов;
        // смысл может зависеть от того, как реализован
        // интерфейс Comparable:
        print("Collections.max(c) = " + Collections.max(c));
        print("Collections.min(c) = " + Collections.min(c));
        // Добавление Collection в другой объект Collection
        Collection<String> c2 = new ArrayList<String>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        print(c);
        c.remove(Countries.DATA[0][0]);
        print(c);
        c.remove(Countries.DATA[1][0]);
        print(c);
        // Удаление всех компонентов, присутствующих
        // в коллекции-аргументе:
        c.removeAll(c2);
        print(c);
        c.addAll(c2);
        print(c);
        // Элемент присутствует в Collection?
        String val = Countries.DATA[3][0];
        print("c.contains(" + val + ") = " + c.contains(val));
        // Содержимое Collection входит в другой объект Collection?
        print("c.containsAll(c2) = " + c.containsAll(c2));
        Collection<String> c3 = ((List<String>)c).subList(3, 5);
        // Оставить все элементы, присутствующие
        // в с2 и с3 (пересечение множеств):
        c2.retainAll(c3);
        print(c2);
        // Удалить из с2 все элементы,
        // также присутствующие в c3:
        c2.removeAll(c3);
        print("c2.isEmpty(): " + c2.isEmpty());
        c = new ArrayList<String>();
        c.addAll(Countries.names(6));
        print(c);
        c.clear(); // Удаление всех элементов
        print("after c.clear(): " + c);
    }
}
