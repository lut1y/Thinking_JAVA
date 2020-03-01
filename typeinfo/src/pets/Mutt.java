package pets;

import factory.Factory;

/**
 * Created by 123 on 07.11.2019.
 */
public class Mutt extends Dog {
    public Mutt(String name) { super(name); }
    public Mutt() { super(); };

    public static class Factory implements factory.Factory {
        public Mutt create() {
            return new Mutt();
        }
    }
}
