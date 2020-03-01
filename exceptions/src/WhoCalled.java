/**
 * Created by Dmitriy on 14.11.2019.
 */

// Программный доступ к информации трассировки стека.
public class WhoCalled {
    static void f() {
        // Генерируем исключение для заполения трассировки стека
        try {
            throw new Exception();
        } catch (Exception e) {
            for(StackTraceElement ste : e.getStackTrace())
                System.out.println(ste.getMethodName());
        }
    }
    static void g() { f(); }
    static void h() { g(); }
    public static void main(String[] args) {
        f();
        System.out.println("--------------------");
        g();
        System.out.println("--------------------");
        h();
    }
}
