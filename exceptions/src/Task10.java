/**
 * Created by Dmitriy on 24.12.2019.
 */

public class Task10 {
    private static void f() {
        System.out.println("Тело f()");
        try {
            g();
        } catch(Exception ex) {
            System.out.println("*** Исключение из f() ***");
            ex.printStackTrace(System.out);
        }
    }

    private static void g() throws MyExc{
        System.out.println("Тело g()");
        try {
//            throw new MyExc("ИСКЛЮЧЕНИЕ");
//        } catch (MyExc me) {
            throw new RuntimeException();
        } catch (RuntimeException re) {
            System.out.println("*** Исключение из g()");
//            me.printStackTrace(System.out);
//            throw me;
            re.printStackTrace(System.out);
            throw re;
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
