/**
 * Created by Dmitriy on 14.11.2019.
 */
public class Task2 {
    private static Object obj = null;

    public static void main(String[] args) {
        try {
            System.out.println(obj.toString());
        } catch (Exception e) {
            System.out.println("***");
            System.out.println("Перехват исключения");
            e.printStackTrace(System.out);
        }
    }
}
