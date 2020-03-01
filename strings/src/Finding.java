import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy on 15.01.2020.
 */
public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+")
                .matcher("Evening is full of the linnet's wings");
        while(m.find())
            System.out.print(m.group() + " ");
        System.out.println();
        int i=0;
        while(m.find(i)) { // i - символ, с которого начинается поиск
            System.out.print(m.group() + " ");
            i++;
        }
    }
}
