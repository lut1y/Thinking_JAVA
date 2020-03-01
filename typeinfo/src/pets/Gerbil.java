package pets;

/**
 * Created by Dmitriy on 30.01.2020.
 */
public class Gerbil extends Rodent {
    public Gerbil(String name) { super(name); }
    public Gerbil() { super(); }

    public static class Factory implements factory.Factory {
        public Gerbil create() {
            return new Gerbil();
        }
    }
}
