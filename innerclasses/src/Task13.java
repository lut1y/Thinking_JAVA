/**
 * Created by Dmitriy on 06.12.2019.
 */

class Outer13 {
    Outer13() {}
    Outer13(int i) {
        System.out.println("i: " + i);
    }
}

public class Task13 {
    public Outer13 outer13 () {
        return new Outer13(12) {
            public void meth() {
                System.out.println("meth()");
            }
        };
    }

    public static void main(String[] args) {
        Task13 t13 = new Task13();
        Outer13 outer = t13.outer13();
        System.out.println(outer);
    }
}
