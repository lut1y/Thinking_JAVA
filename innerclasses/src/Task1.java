/**
 * Created by Dmitriy on 04.12.2019.
 */

public class Task1 {

    class Outer {
        private String s;

        class Inner {
            Inner() {
                System.out.println("Inner constructor");
            }
        }
        public Inner createInner() {
            return new Inner();
        }
        Outer() {
            this.s = "";
            System.out.println("Outer constructor");
        }
    }



    public static void main(String[] args) {
        Task1 t1 = new Task1();
        Outer outer = t1. new Outer();
        Outer.Inner inner = outer.createInner();
        Outer.Inner inner1 = outer. new Inner();
    }
}
