package pets;

/**
 * Created by 123 on 07.11.2019.
 */
public class Rodent extends Pet{
    public Rodent(String name) { super(name); }
    public Rodent() { super(); }

    public static class Factory implements factory.Factory {
        public Rodent create() {
            return new Rodent();
        }
    }
}
