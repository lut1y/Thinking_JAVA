import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy on 16.01.2020.
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input =
                "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input, 3)));
    }
}
