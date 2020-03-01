/**
 * Created by Dmitriy on 06.12.2019.
 */

interface Interf {
    void meth();
}

public class Task10 {
    public Interf interf() {
        return new Interf() {

            @Override
            public void meth() {
                System.out.println("Метод meth()");
            }
        };
    }
    public static void main(String[] args) {
        Task10 t10 = new Task10();
        t10.interf().meth();
    }
}
