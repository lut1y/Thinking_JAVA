package packageaccess;

import static util.Print.print;

class C implements interfacea.AA {

    public void f() {print("public C.f()");}
    public void g() {print("public C.g()");}
    void u() { print("package C.u()");}
    protected void v() {print("protected C.v()");}
    private void w() {print("private C.w()");}
}

public class HiddenC {
    public static interfacea.AA makeA() {return new C();}
}
