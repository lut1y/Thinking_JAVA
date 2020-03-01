package interfaceprocessor;

import java.util.Arrays;

/**
 * Created by 123 on 29.10.2019.
 */
public abstract class StringProcessor implements Processor {
    public String name() { return getClass().getSimpleName(); }
    public abstract String process(Object input);
    public static String s = "If she weighs the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new Splitter(), s);
        Apply.process(new Replace(), s);
        Apply.process(new StringProcessor() {

            @Override
            public String process(Object input) {
                return ((String)input).toLowerCase();
            }
        }, s);
    }
}

class Upcase extends StringProcessor {
    public String process(Object input) { return ((String)input).toUpperCase();}

}

class Splitter extends StringProcessor {
    public String process(Object input) { return Arrays.toString(((String)input).split(" ")); }
}

class Replace extends StringProcessor {
    public String process(Object input) {
        String[] words = ((String)input).split(" ");
        String buff;
        for(int i=0; (i+2) < words.length; i=i+2) {
            buff = words[i];
            words[i] = words[i+1];
            words[i+1] = buff;
        }
        return Arrays.toString(words);
    }
}
