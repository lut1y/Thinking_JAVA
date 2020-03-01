package pets;

import factory.Factory;

/**
 * Created by 123 on 07.11.2019.
 */
public class Pet extends Individual {
    public Pet(String name) { super(name); }
    public Pet() {super(); }

    public static class Factory implements factory.Factory {
        public Pet create() {
            return new Pet();
        }
    }
}
