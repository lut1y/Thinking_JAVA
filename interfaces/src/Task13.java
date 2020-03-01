/**
 * Created by Dmitriy on 03.12.2019.
 */
interface IntTask13 {
    void meth1();
}

interface IntTask13_1 extends IntTask13 {
    void meth2();
}

interface IntTask13_2 extends IntTask13 {
    void meth3();
}


public class Task13 implements IntTask13_1, IntTask13_2{
    public static void main(String[] args) {
        Task13 t13 = new Task13();
        t13.meth1();
        t13.meth2();
        t13.meth3();
    }

    @Override
    public void meth1() {
        System.out.println("meth1");
    }

    @Override
    public void meth2() {
        System.out.println("meth2");
    }

    @Override
    public void meth3() {
        System.out.println("meth3");
    }
}
