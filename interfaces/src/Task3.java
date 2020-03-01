/**
 * Created by Dmitriy on 03.12.2019.
 */

abstract class TesTask3 {
    abstract void print();
    public TesTask3 () {
        print();
    }
}

public class Task3 extends TesTask3 {
    public int i=5;

    @Override
    void print() {
        System.out.println("Task: " + i);
    }

    public static void main(String[] args) {
        Task3 t3 = new Task3();
        t3.print();
    }
}
