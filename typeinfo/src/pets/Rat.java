package pets;

/**
 * Created by 123 on 07.11.2019.
 */
public class Rat extends Rodent{
    public Rat(String name) { super(name); }
    public Rat() { super(); }

    public static class Factory implements factory.Factory {
        public Rat create() {
            return new Rat();
        }
    }
}
