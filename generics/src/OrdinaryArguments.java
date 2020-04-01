class OrdinarySetter {
    void set(Base1 base) {
        System.out.println("OrdinarySetter.set(Base1)");
    }
}

class DerivedSetter extends OrdinarySetter {
    void set(Derived1 base) {
        System.out.println("DerivedSetter.set(Derived1)");
    }
}

public class OrdinaryArguments {
    public static void main(String[] args) {
        Base1 base = new Base1();
        Derived1 derived = new Derived1();
        DerivedSetter ds = new DerivedSetter();
        ds.set(derived);
        ds.set(base);
    }
}
