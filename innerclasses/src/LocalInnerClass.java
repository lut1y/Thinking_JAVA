/**
 * Created by 123 on 06.11.2019.
 */
// Хранит последовательность объектов.

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(final String name) {
        // Локальный внутренний класс
        class LocalCounter implements Counter{
            public LocalCounter() {
                // У локального внутреннего класса
                // может быть собственный конструктор:
                System.out.println("LocalCounter()");
            }
            public int next() {
                System.out.print(name); // Неизменный аргумент
                return count++;
            }
        }
        return new LocalCounter();
    }
    // То же с анонимным внутренним классом:
    Counter getCounter2(final String name) {
        return new Counter() {
            // Анонимный внутренний класс не может содержать
            // именованного конструтора, только инициализатор экземепляра:
            {
                System.out.println("Counter()");
            }
            public int next() {
                System.out.print(name); // Неизменный аргумент
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Локальный "),
                c2 = lic.getCounter2("Анонимный ");
        for(int i = 0; i < 5; i++)
            System.out.println(c1.next());
        for(int i = 0; i < 5; i++)
            System.out.println(c2.next());
    }
}
