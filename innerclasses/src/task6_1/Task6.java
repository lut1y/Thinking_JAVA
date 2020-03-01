package task6_1;

import task6_3.IFClass;

/**
 * Created by Dmitriy on 05.12.2019.
 */
public class Task6 extends task6_3.IFClass {
    public void meth() {
        System.out.println("meth()");
    }

    public static void main(String[] args) {
        Task6 t61 = new Task6();
        Inner inner = t61. new Inner();
        inner.meth();

    }
}
