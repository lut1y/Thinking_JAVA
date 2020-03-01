/**
 * Created by 123 on 01.11.2019.
 */
public class Outer {
    private String s;

    Outer( String s) { this.s = s; }


    class Inner {
        public String toString(String s) {
            return s;
        }
    }

    public Inner ret () { return new Inner(); }

    public static void main(String[] args) {
        Outer o = new Outer("Тест");
        Outer.Inner i = o.ret();
        i.toString(o.s);
    }
}
