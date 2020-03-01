package rodents;

/**
 * Created by Dmitriy on 03.12.2019.
 */
class Mouse implements Rodent {
    @Override
    public void eat() {
        System.out.println("Mouse.eat()");
    }

    @Override
    public void run() {
        System.out.println("Mouse.run()");
    }

    public String toString() {
        return "Mouse";
    }
}
