/**
 * Created by Dmitriy on 14.11.2019.
 */
class MyExc extends Exception {
    MyExc(String s) {
        super(s);
    }
}

public class Task1 {
    private void f() throws MyExc {
        System.out.println("Иключение MyExc из f()");
        throw new MyExc("Создано в f()");
    }

    public static void main(String[] args) {
        Task1 t1 = new Task1();
        try {
            t1.f();
        } catch (MyExc me) {
            System.out.println("***");
            System.out.println("Исключение перехвачено");
            System.out.println(me.getMessage());
            me.printStackTrace(System.out);
        }
        finally {
            System.out.println("***");
            System.out.println("Финализация");
        }
    }
}
