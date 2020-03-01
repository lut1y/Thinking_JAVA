/**
 * Created by Dmitriy on 24.12.2019.
 */

class GException extends Exception {
    GException(String s) { super(s); }
}

class  HException extends Exception {
    HException(String s) { super(s); }
}


public class Task10_ {
    static void f() {
        try {
            try {
                g();
//            } catch(GException ge) {
            } catch(RuntimeException ge) {
                System.out.println("Caught GException in f inner try");
                ge.printStackTrace(System.out);
                throw new HException("from f(), inner try");
            }
        } catch(HException he) {
            System.out.println("Caught HException in f() outer try");
            he.printStackTrace(System.out);
        }
    }

    static void g() {//throws GException {
//        throw new GException("from g()");
        throw new RuntimeException("from g()");
    }
    public static void main(String[] args) {
        f();
    }
}

