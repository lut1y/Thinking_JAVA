package pets;

/**
 * Created by 123 on 07.11.2019.
 */
public class Pug extends Dog {
    public Pug(String name) { super(name); }
    public Pug() { super(); }

    public static class Factory implements factory.Factory {
        public Pug create() {
            return new Pug();
        }
    }
}
