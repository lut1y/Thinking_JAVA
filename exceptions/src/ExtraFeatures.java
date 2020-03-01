/**
 * Created by Dmitriy on 23.12.2019.
 */

class MyException2 extends Exception {
    private int x;
    public MyException2() {}
    public MyException2(String msg) {super(msg);}
    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }
    public int val() {return x;}
    public String getMessage() {
        return "Подробное сообщение: " + x + " " + super.getMessage();
    }
}

public class ExtraFeatures {
    public static void f() throws MyException2 {
        System.out.println("*** ФУНКЦИЯ ***");
        System.out.println("Возбуждаем MyException2 из f()");
        throw new MyException2();
    }
    public static void g() throws MyException2 {
        System.out.println("*** ФУНКЦИЯ ***");
        System.out.println("Возбуждаем MyException2 из g()");
        throw new MyException2("Создано в g()");
    }
    public static void h() throws MyException2 {
        System.out.println("*** ФУНКЦИЯ ***");
        System.out.println("Возбуждаем MyException2 из h()");
        throw new MyException2("Создано в h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
            System.out.println("*** ИСКЛЮЧЕНИЕ ***");
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException2 e) {
            System.out.println("*** ИСКЛЮЧЕНИЕ ***");
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (MyException2 e) {
            System.out.println("*** ИСКЛЮЧЕНИЕ ***");
            e.printStackTrace(System.out);
            System.out.println("e.val() = " + e.val());
        }
    }
}
