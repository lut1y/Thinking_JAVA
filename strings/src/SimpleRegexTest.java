import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy on 14.01.2020.
 */
public class SimpleRegexTest {
    public static void main(String[] args) {
        String myText = "this is my 1st test string";
        String myRegex = "\\d+\\w+";
        Pattern p = Pattern.compile(myRegex);
        Matcher m = p.matcher(myText);

        if(m.find()) {
            String matchedText = m.group();
            int matchedFrom = m.start();
            int matchedTo = m.end();
            System.out.println("matched [" + matchedText + "] " +
            "from " + matchedFrom +
            " to " + matchedTo + ".");
        } else {
            System.out.println("didn't match");
        }
    }
}
