/**
 * Created by Dmitriy on 06.12.2019.
 */
public class Task16 {
    private static class Inner {
        Inner() {
            System.out.println("Inner constructor");
        }
    }

    public static Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Task16 t16 = new Task16();
        Inner inner = inner();
    }
}
