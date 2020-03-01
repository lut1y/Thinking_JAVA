package pets;

/**
 * Created by 123 on 07.11.2019.
 */
public class Hamster extends Rodent {
    public Hamster(String name) { super(name); }
    public Hamster() { super(); }

    public static class Factory implements factory.Factory {
        public Hamster create() {
            return new Hamster();
        }
    }
}
