/**
 * Created by Dmitriy on 05.12.2019.
 */

class PrivCls {
    private String s = "Было";
    private void meth() {
        System.out.println(s);
    }

    class Inner {
        private String t = "close_value";

        void changeField(String p) {
            s = p;
            meth();
        }
    }

    public void meth2() {
        Inner inner = new Inner();
        inner.changeField("Стало");
        System.out.println(inner.t);
    }


}

public class Task7 {
    public static void main(String[] args) {
        PrivCls t7 = new PrivCls();
        t7.meth2();
        System.out.println(t7);
    }
}
