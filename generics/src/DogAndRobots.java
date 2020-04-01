import pets.Dog;

import static util.Print.print;

class PerformingDog extends Dog implements Performs {
    public void speak() { print("Woof!"); }
    public void sit() { print("Sitting!");}
    public void reproduce() {}
}

class RoboT implements Performs {
    public void speak() { print("Click!"); }
    public void sit() { print("Clank!");}
    public void oilChange() {}
}

class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogAndRobots {
    public static void main(String[] args) {
        PerformingDog d = new PerformingDog();
        RoboT r = new RoboT();
        Communicate.perform(d);
        Communicate.perform(r);
    }
}
