/**
 * Created by 123 on 01.11.2019.
 */

public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    private class Inner {
        public DotThis outer() {
            return DotThis.this;
            // "this" без уточнения соответствует объекту Inner
        }
    }
    public Inner inner() { return new Inner(); }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
