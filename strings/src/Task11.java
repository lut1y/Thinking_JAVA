import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy on 15.01.2020.
 */
public class Task11 {
    public static void main(String[] args) {
        String s = "Arline ate eight apples and one orange while Anita hadn't any";
        System.out.println(s.matches("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b"));

        Pattern p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        Matcher m = p.matcher(s);

        while(m.find()) {
            System.out.print(m.group());
        }
    }
}
