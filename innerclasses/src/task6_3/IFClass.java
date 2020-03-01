package task6_3;
import task6.IF1;

/**
 * Created by Dmitriy on 05.12.2019.
 */

public class IFClass{

    protected class Inner implements IF1 {
        public Inner() {
            System.out.println("Inner constructor");
        }

        @Override
        public void meth() {
            System.out.println("Inner.meth()");
        }

        public Inner inner() {return new Inner(); }
    }
}