/**
 * Created by Dmitriy on 03.12.2019.
 */
public class Task5 implements task5.Task5 {
    @Override
    public void meth1() {
        System.out.println("Task5.meth1");
    }

    @Override
    public void meth2() {
        System.out.println("Task5.meth2");
    }

    @Override
    public void meth3() {
        System.out.println("Task5.meth3");
    }
    public static void main(String[] args) {
        Task5 t5 = new Task5();
        t5.meth1();
        t5.meth2();
        t5.meth3();
    }
}
