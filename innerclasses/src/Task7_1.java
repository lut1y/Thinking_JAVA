/**
 * Created by Dmitriy on 05.12.2019.
 */

interface OneMeth {
    void meth();
}

public class Task7_1 {

    public OneMeth bigMethod() {
        class InnerMeth implements OneMeth {
            InnerMeth() {
                System.out.println("InnerMeth constructor");
            }
            @Override
            public void meth() {
                System.out.println("Метод meth()");
            }
        }
        OneMeth om = new InnerMeth();
        return om;
    }

    public static void main(String[] args) {
        Task7_1 t74 = new Task7_1();
        t74.bigMethod().meth();
    }
}
