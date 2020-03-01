import util.TextFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy on 17.01.2020.
 */
public class JGrep {
    private static int convertConstToInt(List<String> list) {
        int result = 0;
        for(int i=0; i< list.size(); i++) {
            switch (list.get(i)) {
                case "Pattern.UNIX_LINES": result = result | 0x01; break;
                case "Pattern.CASE_INSENSITIVE": result = result | 0x02;break;
                case "Pattern.COMMENTS": result = result | 0x04; break;
                case "Pattern.MULTILINE": result = result | 0x08; break;
                case "Pattern.LITERAL": result = result | 0x10; break;
                case "Pattern.DOTALL": result = result | 0x20; break;
                case "Pattern.UNICODE_CASE": result = result | 0x40; break;
                case "Pattern.CANON_EQ": result = result | 0x80; break;
                case "Pattern.UNICODE_CHARACTER_CLASS": result = result | 0x100; break;
                default: result = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }

        // ***16***
        File[] files = new File(args[0]).listFiles();
        // ********

        // ***15***
        Pattern p;
        if (args.length > 2) {
            List<String> sb = new ArrayList<String>();
            for(int i = 2; i < args.length; i++)
                sb.add(args[i]);
            p = Pattern.compile(args[1], convertConstToInt(sb));
        } else {
            p = Pattern.compile(args[1]);
        }
        // ***

//        p = Pattern.compile(args[1]);
        int index = 0;
        Matcher m = p.matcher("");

        for(File f : files) {
            System.out.println("File: " + f.getName());
            for(String line : new TextFile(f.getAbsolutePath())) {
                m.reset(line);
                while(m.find())
                    System.out.println(index++ + ": " +
                    m.group() + ": " + m.start());
            }
        }
    }
}
