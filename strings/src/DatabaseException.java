/**
 * Created by Dmitriy on 13.01.2020.
 */
public class DatabaseException extends Exception {
    public DatabaseException(int transactionID, int queryID, String message) {
        super(String.format(("(t%d, q%d) %s"), transactionID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Ошибка записи");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
