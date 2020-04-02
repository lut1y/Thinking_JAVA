package pets;

/**
 * Created by 123 on 07.11.2019.
 */
public class Dog extends Pet {
    public Dog(String name) {super(name);}
    public Dog() {super();}

    public static class Factory implements factory.Factory {
        public Dog create() {
            return new Dog();
        }
    }

    @Override
    public void speak() {
        System.out.println(this + " speak \"Woof!\"");
    }
}
