package classprocessor;

/**
 * Created by 123 on 29.10.2019.
 */

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Используем Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s = "Disagreement with beliefs is by definition inscorrect";
    public static void main(String[] args) {
        process(new Upcase(), s);
    }
}
