package rodents;

/**
 * Created by Dmitriy on 03.12.2019.
 */
class Hamster implements Rodent {
    @Override
    public void run() {
        System.out.println("Hamster.run()");
    }

    @Override
    public void eat() {
        System.out.println("Hamster.eat()");
    }

    public String toString() {
        return "Hamster";
    }
}
