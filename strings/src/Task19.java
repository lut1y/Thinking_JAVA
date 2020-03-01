import util.TextFile;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Task19 {
    // Главная функция класса
    public static void main(String[] args) throws Exception {

        if (args.length < 1) { /* сложный комментарий в
        середине */
            System.out.println("Проверьте входные данные!");
            System.exit(0);
        }

        Pattern p = Pattern.compile("[A-Z]\\w+");
        Matcher m = p.matcher("");

        Map<String, Integer> mapCharacter = new HashMap<String, Integer>();
//        String ch;
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while(m.find()) {
//                ch = m.group();
                if(mapCharacter.keySet().contains(m.group())) {
                    mapCharacter.put(m.group(), mapCharacter.get(m.group()) + 1);
                } else {
                    mapCharacter.put(m.group(), 1);
                }
            }
        }
        for(String key : mapCharacter.keySet())
            System.out.format("key: %s, value: %d\n", key, mapCharacter.get(key));

    }
}
