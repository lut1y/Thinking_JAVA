/**
 * Created by Dmitriy on 14.11.2019.
 */

// Создание собственного исклчения.
class SimpleExceptions extends Exception {}

public class InheritingExceptions {
    public void f() throws SimpleExceptions {
        System.out.println("Возбуждаем SimpleException из f()");
        throw new SimpleExceptions();
    }

    public static void main(String[] args) {
        InheritingExceptions ie = new InheritingExceptions();
        try {
            ie.f();
        } catch (SimpleExceptions e) {
            System.out.println("Перехвачено!");
        }
    }
}
