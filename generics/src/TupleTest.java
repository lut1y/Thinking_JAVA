import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import util.*;

class Amphibian {}
class Vehicle {}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        // Автоматическая упаковка преобразует int в Integer:
        return new TwoTuple<String, Integer>("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<Vehicle, Amphibian, String, Integer>(new Vehicle(), new Amphibian(), "hi", 47);
    }
    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    static SixTuple<Vehicle, Amphibian, String, Integer, Double, Boolean> m() {
        return new SixTuple<Vehicle, Amphibian, String, Integer, Double, Boolean>(new Vehicle(), new Amphibian(), "hi", 47, 11.1, Boolean.TRUE);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
//        ttsi.first = "there";
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(m());
    }

}
