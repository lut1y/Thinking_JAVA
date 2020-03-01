/**
 * Created by Dmitriy on 03.12.2019.
 */

interface Interface1 {
    void meth1();
    void meth2();
}

interface Interface2 {
    void meth3();
    void meth4();
}

interface Interface3 {
    void meth5();
    void meth6();
}

interface NewInterface extends Interface1, Interface2, Interface3{
    void meth7();
}

class Task14_1 implements NewInterface{

    @Override
    public void meth1() {

    }

    @Override
    public void meth2() {

    }

    @Override
    public void meth3() {

    }

    @Override
    public void meth4() {
        System.out.println("meth4");
    }

    @Override
    public void meth5() {
        System.out.println("meth5");
    }

    @Override
    public void meth6() {
        System.out.println("meth6");
    }

    @Override
    public void meth7() {
        System.out.println("meth7");
    }
}

abstract class AbsCls {
    abstract void meth8();
}

class extAbsCls extends AbsCls {
    @Override
    void meth8() {
        System.out.println("meth8");
    }
}

public class Task14 extends extAbsCls{
        public static void main(String[] args) {
            Task14 t14 = new Task14();
//            t14.meth7();
//            t14.meth6();
//            t14.meth5();
//            t14.meth4();
            t14.meth8();
        }
}
