// Программирование в обход интерфейса

import interfacea.AA;

class BB implements AA {
    public void f() {}
    public void g() {}

}

public class InterfaceViolation {
    public static void main(String[] args) {
        AA a = new BB();
        a.f();
//        a.g();
        System.out.println(a.getClass().getName());
        if(a instanceof BB) {
            BB b = (BB) a;
            b.g();
        }
    }
}
