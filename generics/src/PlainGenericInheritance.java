class GenericSetter<T> {
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<Base1> {
    void set(Derived1 derived) {
        System.out.println("DerivedGS.set(Derived)");
    }
}

public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base1 base = new Base1();
        Derived1 derived = new Derived1();
        DerivedGS dgs = new DerivedGS();
        dgs.set(derived);
        dgs.set(base);
    }
}
