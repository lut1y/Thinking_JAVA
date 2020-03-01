package pets;

/**
 * Created by 123 on 07.11.2019.
 */
public class Cat extends Pet {
    public Cat(String name) { super(name); }
    public Cat() { super(); }

    public static class Factory implements factory.Factory<Cat> {
        public Cat create() {
            return new Cat();
        }
    }
}
