/**
 * Created by Dmitriy on 23.12.2019.
 */
public class Task3 {
    private static String[] arrString = new String[3];

    public static void main(String[] args) {
        try {
            System.out.println(arrString[4]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("***");
            System.out.println("Перехват");
            System.out.println("getMessage(): " + e.getLocalizedMessage());
            e.printStackTrace(System.out);
        }
    }
}
