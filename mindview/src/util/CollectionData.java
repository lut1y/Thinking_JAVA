package util;
// Заполнение коллекции с использованием объекта генератора.
import java.util.ArrayList;

public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for(int i=0; i < quantity; i++)
            add(gen.next());
    }
    // Обобщенный вспомогательный метод:
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}
