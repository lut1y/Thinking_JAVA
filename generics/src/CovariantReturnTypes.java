class Base1 {}
class Derived1 extends Base1 {}

interface OrdinaryGetter {
    Base1 get();
}

interface DerivedGetter extends OrdinaryGetter {
    Derived1 get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived1 d2 = d.get();
    }
}
