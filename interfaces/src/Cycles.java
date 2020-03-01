/**
 * Created by 123 on 31.10.2019.
 */

interface Cycle { void getWheels(); }
interface CycleFactory { Cycle getCycle(); }
// Unicycle
class Unicycle implements Cycle {
    public void getWheels() {
        System.out.println("Создан велосипед c одним колесом");
    }
}

class UnicycleFactory implements CycleFactory {
    public Cycle getCycle() { return new Unicycle(); }
}

// Bicycle
class Bicycle implements Cycle {
    public void getWheels() {
        System.out.println("Создан велосипед c двумя колесами ");
    }
}

class BicycleFactory implements CycleFactory {
    public Cycle getCycle() { return new Bicycle(); }
}

public class Cycles {
    public static void createCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.getWheels();
    }
    public static void main(String[] args) {
        createCycle(new UnicycleFactory());
        createCycle(new BicycleFactory());
    }
}
