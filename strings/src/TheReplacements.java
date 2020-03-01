import util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy on 16.01.2020.
 */

/*! Here's a block of text to use as input to
 *   the regular expression matcher. Note that we'll
 *   first extract the block of text by looking for
 *   the special delimiters, then process the
 *   extracted block. !*/

public class TheReplacements {
    public static void main(String[] args) throws Exception {
        String s = TextFile.read("C:\\Users\\Dmitriy\\IdeaProjects\\Thinking_Java\\strings\\src\\TheReplacements.java");

        Matcher mInput =
                Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL)
                .matcher(s);
        if(mInput.find())
            s = mInput.group(1);
        s = s.replaceAll(" {2,}", " ");
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]","(VoWeL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
}
