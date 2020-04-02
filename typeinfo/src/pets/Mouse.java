package pets;

/**
 * Created by 123 on 07.11.2019.
 */
public class Mouse extends Rodent {
    public Mouse(String name) { super(name); }
    public Mouse() { super(); }

    public static class Factory implements factory.Factory {
        public Mouse create() {
            return new Mouse();
        }
    }

    @Override
    public void speak() {
        System.out.println(this + " speak \"Pi!\"");
    }
}
