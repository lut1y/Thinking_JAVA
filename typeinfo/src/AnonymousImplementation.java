import interfacea.AA;

import static util.Print.print;

// Анонимные внутренние классы не скрыты от отражения.
class AnonymousA {
    public static AA makeA() {
        return new AA() {
            public void f() {print("public C.f()");}
            public void g() {print("public C.g()");}
            void u() { print("package C.u()");}
            protected void v() {print("protected C.v()");}
            private void w() {print("private C.w()");}
        };
    }
}

public class AnonymousImplementation {
    public static void main(String[] args) throws Exception {
        AA a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
