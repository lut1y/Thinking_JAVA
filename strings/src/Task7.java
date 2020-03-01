/**
 * Created by Dmitriy on 14.01.2020.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    public static void main(String[] args) {
        String sen = "^[A-Z].*[\\.]$";

        String text1 = "Once upon a time.";
        String text2 = "abcd.";
        String text3 = "Abcd?";
        String text4 = "An easy way out.";
        String text5 = "Zorro.";
        String text6 = "X.";

        System.out.println(text6.matches(sen));


        System.out.println("***");

        Pattern p = Pattern.compile("^[A-Z]+.*[.]$");
        Matcher m = p.matcher(text6);

        while(m.find())
            System.out.println(m.group());
    }
}
