import java.util.Arrays;
import java.util.List;

class Generic1<T> {
    T item;
    public void set(T item) {
        this.item = item;
    }
}

class Generic2<T> {
    T item;
    public T get() {
        return item;
    }
}

public class Task28<T> {
    <T> void covatiantSet(Generic1<? super T> g1t, T t) {
        g1t.set(t);
    }
    <T> T covatiantGet(Generic2<? extends T> g2T) {
        return g2T.get();
    }

    public static void main(String[] args) {
        Task28<Jonathan> jonathanTask28 = new Task28<Jonathan>();
        jonathanTask28.covatiantSet(new Generic1<Apple>(), new Jonathan());
        System.out.println(jonathanTask28.covatiantGet(new Generic2<Jonathan>()));

    }
}
