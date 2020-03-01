/**
 * Created by Dmitriy on 25.12.2019.
 */
class ConstructorException {
    public ConstructorException() throws Exception {
        try {
            throw new Exception("Искусственное исключение!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class Task21 extends ConstructorException{

    public Task21() throws Exception {
        System.out.println("Конструктор Task21");
    }

    public static void main(String[] args) {
        try {
            Task21 t21 = new Task21();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
