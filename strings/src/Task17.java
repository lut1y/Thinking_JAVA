import util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Created by Dmitriy on 17.01.2020.
*/

/*  Сложный... очень сложный комментарий!
    В несколько строк! */
public class Task17 {
    // Главная функция класса
    public static void main(String[] args) throws Exception {

        if (args.length < 1) { /* сложный комментарий в
        середине */
            System.out.println("Проверьте входные данные!");
            System.exit(0);
        }

        Pattern p = Pattern.compile("(//\\s.*)|(/\\*\\s+.+)|(\\*\\s+.+)");
        Matcher m = p.matcher("");

        int index = 0;
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while(m.find()) {
                System.out.println(++index + " : " + m.group());
            }
        }
    }
}
