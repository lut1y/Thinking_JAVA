/**
 * Created by Dmitriy on 15.01.2020.
 */
public class Task9 {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s.replaceAll("a|e|i|o|u|y", "_"));
    }
}
