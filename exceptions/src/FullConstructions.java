/**
 * Created by Dmitriy on 14.11.2019.
 */

class MyException extends Exception {
    public MyException() {}
    public MyException(String msg) {super(msg);}
}

public class FullConstructions {
    public static void f() throws MyException {
        System.out.println("Возбуждаем MyException из f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("Возбуждаем MyException из g()");
        throw new MyException("Создано в g()");
    }
    public static void main(String[] args) {
        try{
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }


}
