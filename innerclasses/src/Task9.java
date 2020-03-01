/**
 * Created by Dmitriy on 06.12.2019.
 */

interface OpenInterface {}

public class Task9 {
    private class Inner implements OpenInterface {
        OpenInterface meth() {
            return new Inner();
        }
    }

    public static void main(String[] args) {
        Task9 t9 = new Task9();
//        Inner inner = new t9.Inner();
    }

}
