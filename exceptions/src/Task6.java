/**
 * Created by Dmitriy on 23.12.2019.
 */

class MyExc1 extends Exception {}
class MyExc2 extends Exception {}

public class Task6 {
    public static void main(String[] args) {
        try {
            throw new MyExc1();
        } catch (MyExc1 me) {
            System.out.println("***");
            System.out.println("getMessage: " + me.getLocalizedMessage());
            me.printStackTrace(System.out);
        }

        try {
            throw new MyExc2();
        } catch (MyExc2 me) {
            System.out.println("***");
            System.out.println("getMessage: " + me.getLocalizedMessage());
            me.printStackTrace(System.out);
        }
    }
}
