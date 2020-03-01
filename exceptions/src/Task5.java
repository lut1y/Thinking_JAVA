/**
 * Created by Dmitriy on 23.12.2019.
 */
public class Task5 {
    private static String s[] = new String[3];

    public static void main(String[] args) {
        int i = 5;
        while (i > 3) {
            try {
                System.out.println(s[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("*** EXCEPTION ***");
                e.printStackTrace(System.out);
            }
            i--;
        }
        System.out.println("END!");
    }
}
