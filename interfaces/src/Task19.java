import java.util.Random;

/**
 * Created by Dmitriy on 04.12.2019.
 */

interface Keep {
    Random rand = new Random();
    void getKeep();}
interface KeepFactory { Keep getKeep(); }

class MoneyFactoryNew implements KeepFactory {

    @Override
    public Keep getKeep() {
        return new Keep() {
            @Override
            public void getKeep() {
                if(rand.nextBoolean()) {
                    System.out.println("Монета: Орел");
                } else {
                    System.out.println("Монета: Решка");
                }
            }
        };
    }
}

class CubeFactoryNew implements KeepFactory {

    @Override
    public Keep getKeep() {
        return new Keep() {
            @Override
            public void getKeep() {
                System.out.println("Кости: выпало " + (rand.nextInt(5)+1));
            }
        };
    }
}

public class Task19 {
    public static void createKeep(KeepFactory factory) {
        Keep k = factory.getKeep();
        k.getKeep();
    }
    public static void main(String[] args) {
        createKeep(new MoneyFactoryNew());
        createKeep(new MoneyFactoryNew());
        createKeep(new MoneyFactoryNew());
        createKeep(new MoneyFactoryNew());
        createKeep(new CubeFactoryNew());
        createKeep(new CubeFactoryNew());
        createKeep(new CubeFactoryNew());
        createKeep(new CubeFactoryNew());
        createKeep(new CubeFactoryNew());


    }
}
