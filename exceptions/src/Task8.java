/**
 * Created by Dmitriy on 24.12.2019.
 */
public class Task8 {
    public static void main(String[] args) {
        try {
            throw new MyException1("ИСКЛЮЧЕНИЕ");
        } catch(MyException1 me) {
            System.out.println("***");
            System.out.println("getLocalizedMessage(): " + me.getLocalizedMessage());
            me.printStackTrace(System.out);
        }
    }
}
