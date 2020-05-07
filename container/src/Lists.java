import util.Countries;

import java.util.*;

import static util.Print.print;
import static util.Print.printnb;

public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;
    public static void basicTest(List<String> a) {
        a.add(1, "x");
        a.add("x");

        a.addAll(Countries.names(25));

        a.addAll(3, Countries.names(25));
        b = a.contains("1");

        b = a.containsAll(Countries.names(25));
        // Списки обеспевивают произвольный доступ -
        // быстрый для ArrayList, медленный для LinkedList:
        s = a.get(1);
        i = a.indexOf("1");
        b = a.isEmpty();
        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3);
        i = a.lastIndexOf("1");
        a.remove(1);
        a.remove("3");
        a.set(1, "y");
        // Оставить все элеенты, присутствующие в аргументе
        // (пересечение двух множеств):
        a.retainAll(Countries.names(25));

        a.retainAll(Countries.names(25));
        i = a.size();
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManioulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        // Переход к элементу после add():
        it.next();
        // Удаление элемента за вновь созданным:
        it.remove();
        // Переход к элементу после remove();
        it.next();
        // Изменение элемента после удаленного:
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        print(a);
        List<String> b = Countries.names(25);
        print("b = " + b);
        a.addAll(b);
        a.addAll(b);
        print(a);
        ListIterator<String> x = a.listIterator(a.size()/2);
        x.add("one");
        print(a);
        print(x.next());
        x.remove();
        print(x.next());
        x.set("47");
        print(a);
        // Перебор списка в обратном порядке
        x = a.listIterator(a.size());
        while(x.hasPrevious())
            printnb(x.previous() + " ");
        print();
        print("testVisual finished");
    }

    public static void testLinkedList() {
        LinkedList<String> l1 = new LinkedList<String>();
        l1.addAll(Countries.names(25));
        print(l1);
        // Интерпретировать как стек - занесение:
        l1.addFirst("one");
        l1.addFirst("two");
        print(l1);
        // Аналог чтения вершины стека (без извлечения):
        print(l1.getFirst());
        // Аналог извлечения из стека:
        print(l1.removeFirst());
        print(l1.removeFirst());
        // Интерпретировать как очередь c извлечением элементов
        // с конца:
        print(l1.removeLast());
        print(l1);
    }

    public static void main(String[] args) {
        // Каждый раз создается и заполнется новый список:
        basicTest(new LinkedList<String>(Countries.names(25)));
        basicTest(new ArrayList<String>(Countries.names(25)));
        iterMotion(new LinkedList<String>(Countries.names(25)));
        iterMotion(new ArrayList<String>(Countries.names(25)));
        iterManioulation(new LinkedList<String>(Countries.names(25)));
        iterManioulation(new ArrayList<String>(Countries.names(25)));
        testVisual(new ArrayList<String>(Countries.names(25)));
        testLinkedList();
    }

}
