/**
 * Created by Dmitriy on 25.12.2019.
 */

class VeryImportantException extends Exception {
    public String toString() {return "Очень важное исключение!";}
}

class HoHumException extends Exception {
    public String toString() {
        return "Второстепенное исключение";
    }
}

class ThirdException extends Exception {
    public String toString() {
        return "Третье исключение";
    }
}

public class LostMessage{
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    void  g() throws ThirdException {
        throw new ThirdException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
//                try {
                try {
                    lm.dispose();
                } finally {
                    lm.g();
                }
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
