package coffee;
import util.Generator;
import java.util.*;

// Генерирование разных типов Coffee
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = { Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class, };
    private static Random rand = new Random(47);
    public CoffeeGenerator() {}
    // Для перебора:
    private int size = 0;
    public CoffeeGenerator(int sz) { size = sz; }
    public Coffee next() {
        // возвращает случайный объект Coffee
        try {
            return (Coffee)
                types[rand.nextInt(types.length)].newInstance();
//            return CoffeeFactories.createRandom();
            // Сообщить программисту об ошибках во время выполнения
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    class CoffeeIterator implements Iterator<Coffee> {
        // Итератор
        int count = size;
        public boolean hasNext() {
            return count > 0;
        }
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
        public void remove() { // Не реализован
            throw new UnsupportedOperationException();
        }
    };
    public Iterator<Coffee> iterator() {
        // Переназначаем итераторы
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for(int i=0; i < 5; i++)
            System.out.println(gen.next());
        for(Coffee c : new CoffeeGenerator(5))
            System.out.println(c);
    }
}
