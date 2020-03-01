package Switch;

/**
 * Created by Dmitriy on 24.12.2019.
 */
public class OnOffSwitch {
    private static Switch sw = new Switch();
    private static Integer x[] = new Integer[1];
    public static void f(int x) throws OnOffException1, OnOffException2 {}
//    public static void f() throws OnOffException1, OnOffException2 {}

    public static void main(String[] args) {
        try {
            sw.on();
            f(x[0]);
//            f();
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}
