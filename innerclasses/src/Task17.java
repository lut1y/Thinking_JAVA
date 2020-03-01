/**
 * Created by Dmitriy on 06.12.2019.
 */

public class Task17 {
    Task17() {
        System.out.println("Task17 constructor");
    }

    class Outer {
        Outer() {
            System.out.println("Outer constructor");
        }

        class Inner {
            Inner() {
                System.out.println("Inner constructor");
            }
        }
    }

    public static void main(String[] args) {
        Task17 t17 = new Task17();
        Outer outer = t17. new Outer();
        Outer.Inner inner = outer. new Inner();
    }
}
