import factory.Factory;
import util.Null;

import java.util.*;

// Регистрация фабрик класса в базовом классе.
class Part {
    public String toString() {
        return getClass().getSimpleName();
    }
    // Список partFactories содержит интерфейс, который
    // наследуется от Part
    static List<Factory<? extends Part>> partFactories =
            new ArrayList<Factory<? extends Part>>();
//    static List<Class<? extends Part>> partList =
//            new ArrayList<Class<? extends Part>>();
    static {
        // Для Collections.addAll() выдается предупреждение
        // "неконтролируемое создание обобщенного массива"
        // Добавляем в список объекты классаов-фабрик
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
        partFactories.add(new NullPart.Factory());
        partFactories.add(new NullPart.Factory());
//        partList.add(FuelFilter.class);
//        partList.add(AirFilter.class);
//        partList.add(CabinAirFilter.class);
//        partList.add(OilFilter.class);
//        partList.add(FanBelt.class);
//        partList.add(PowerSteeringBelt.class);
//        partList.add(GeneratorBelt.class);
    }
    private static Random rand = new Random(47);

    public static Part createRandom() {
        // Публичный статический метод, возвращающий
        // Part-объект, который выбирается случайным образом из списка
        // partFactories
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
//        int n = rand.nextInt(partList.size());
//        try {
//            return partList.get(n).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
    }
}

class Filter extends Part {}

class NullPart extends Part implements Null {
    private NullPart() {super();}
    public static final Part NULL = new NullPart();
    public static class Factory implements factory.Factory<NullPart> {
        public NullPart create() {return (NullPart) NULL;}
    }

    public String toString() {
        return "NULL";
    }
}

class FuelFilter extends Filter {
    // Создание фабрики класса для каждого конкретного типа:
    public static class Factory implements factory.Factory<FuelFilter> {
        public FuelFilter create() { return new FuelFilter();}
    }
}

class AirFilter extends Filter {
    public static class Factory implements factory.Factory<AirFilter> {
        // Внутренний статический класс, реализующий интерфейс из модуля factory,
        // интерфейс Factory
        public AirFilter create() { return new AirFilter(); }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements factory.Factory<CabinAirFilter> {
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements factory.Factory<OilFilter> {
        public OilFilter create() { return new OilFilter(); }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements factory.Factory<FanBelt> {
        public FanBelt create() { return new FanBelt(); }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements factory.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements factory.Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}