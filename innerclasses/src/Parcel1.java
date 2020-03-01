/**
 * Created by 123 on 31.10.2019.
 */
// Создание внутренних классов

public class Parcel1 {
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }
    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }
    // Использование внутренних классов похоже
    // на использование любых других классов,
    // в пределах Parcell1:
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        Destination f = new Destination(dest + " f()");
        System.out.println(d.readLabel());
        System.out.println(f.readLabel());
        System.out.println(c.value());
    }
    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Танзания");

    }
}
