/**
 * Created by Dmitriy on 03.12.2019.
 */
abstract class TaskTest4 {}

public class Task4 extends TaskTest4{
    public static TaskTest4 ref() {
        return new Task4();
    }
    public void print() {
        System.out.println("Task4.print()");
    }
    public static void main(String[] args) {
        TaskTest4 t4 = new Task4();
        System.out.println(t4);
    }
}
