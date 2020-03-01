/**
 * Created by Dmitriy on 24.12.2019.
 */
class E1 extends Exception {}
class E2 extends Exception {}
class E3 extends Exception {}

public class Task9 {
    private static void f(int i) throws E1, E2, E3 {
        if(i < 0) throw new E1();
        if(i==0) throw new E2();
        if(i > 0) throw new E3();
    }

    public static void main(String[] args) throws E2, E1, E3 {
        try {
            f(0);
            f(-1);
            f(1);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            System.out.println("Финализация основного блока");
            try {
                throw new NullPointerException();
            } catch (NullPointerException npe) {
                npe.printStackTrace(System.out);
            } finally {
                System.out.println("Финализация дополнительного блока");
            }
        }

    }
}
