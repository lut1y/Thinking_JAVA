/**
 * Created by Dmitriy on 14.11.2019.
 */

// Демонстрация методов класса Exception.
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("Мое исключение");
        } catch(Exception e) {
            System.out.println("Перехвачено");
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("toString(): " + e.toString());
            System.out.println("printStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }
}
