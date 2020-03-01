package toys;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Dmitriy on 22.01.2020.
 */

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface PlayMusic {}

class Toy {
    public Toy() {}
    public Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, PlayMusic {
    FancyToy() { super(1); }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Имя класса: " + cc.getName() + " является программным интерфейсом? [" + cc.isInterface() + "]");
        System.out.println("Простое имя: " + cc.getSimpleName());
        System.out.println("Каноническая имя: " + cc.getCanonicalName());
        System.out.println();
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Не удается найти FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces())
            printInfo(face);

        // Task19
        Object obj = null;
        try {
            Toy.class.getDeclaredConstructor(int.class).newInstance(1);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//        Class up = c.getSuperclass();
//        Object obj = null;
//        try {
//            obj = up.newInstance();
//        } catch (InstantiationException e) {
//            System.out.println("Не удалось создать экземпляр");
//            System.exit(1);
//        } catch (IllegalAccessException e) {
//            System.out.println("Отказано в доступе");
//            System.exit(1);
//        }
        printInfo(obj.getClass());
    }
}
