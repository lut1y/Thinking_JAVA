/**
 * Created by Dmitriy on 05.12.2019.
 */

class Outer1 {
    public Outer1() {
        System.out.println("Outer1 constructor");
    }

    class Inner {
        public Inner() {
            System.out.println("Inner constructor");
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        Outer1.Inner inner = outer. new Inner();
    }
}
