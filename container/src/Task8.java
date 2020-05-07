import static util.Print.print;

class Link<E> {
    E e;
    Link<E> next;
    Link(E e, Link<E> next) {
        this.e = e;
        this.next = next;
    }
    Link(E e) {
        this(e, null);
    }
    public String toString() {
        if(e == null) return "null";
        return e.toString();
    }
}

class SListIterator<E> {
    Link<E> current;
    SListIterator(Link<E> link) {
        current = link;
    }
    public boolean hasNext() {
        return current.next != null;
    }
    public Link<E> next() {
        current = current.next;
        return current;
    }
    public void insert(E e) {
        current.next = new Link<E>(e, current.next);
        current = current.next;
    }
    public void remove() {
        if(current.next != null)
            current.next = current.next.next;
    }
}

class SList<E> {
    // объявляем и выделяем память под нулевой элемент
    private Link<E> headLink = new Link<E>(null);
    SListIterator<E> iterator() { return new SListIterator<E>(headLink); }

    public String toString() {
        if(headLink.next == null)
            return "SList: []";
        SListIterator<E> it = this.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("SList: [");
        while (it.hasNext())
            sb.append(it.next() + (it.hasNext() ? ", " : ""));
        sb.append("]");
        return sb.toString();
    }
}

public class Task8 {
    public static void main(String[] args) {
        SList<String> list = new SList<String>();
        print(list);
        SListIterator<String> it = list.iterator();
        it.insert("1");
        it.insert("2");
        it.insert("three");
        print(list);
        SListIterator<String> it1 = list.iterator();
        it1.remove();
        print(list);

    }
}
