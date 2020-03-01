/**
 * Created by Dmitriy on 23.12.2019.
 */
class MyException1 extends Exception {
    private String msg;

    MyException1(String msg) {
        super(msg);
        this.msg = msg;
    }

    public void printMsg() {
        System.out.println(msg);
    }
}

public class Task4 {
    public void f() throws MyException1 {
        System.out.println("*** ФУНКЦИЯ ИСКЛЮЧЕНИЯ ***");
        throw new MyException1("Строка исключения");
    }

    public static void main(String[] args) {
        Task4 t4 = new Task4();

        try {
            t4.f();
        } catch (MyException1 me) {
            System.out.println("*** ИСКЛЮЧЕНИЕ ***");
            me.printMsg();
        }

    }
}
