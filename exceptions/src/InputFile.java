import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dmitriy on 26.12.2019.
 */
public class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
        } catch(FileNotFoundException e) {
            System.out.println("Couldn't open " + fname);
            throw e;
        } catch(Exception e) {
            try {
                in.close();
            } catch (IOException e2) {
                System.out.println("ошибка при выполнении in.close()");
            }
            throw e;
        } finally {

        }
    }
    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("ошибка при выполнении readLine()");
        }
        return s;
    }
    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() успешен");
        } catch (IOException e2) {
            throw new RuntimeException("ошибка при выполнении in.close()");
        }
    }
}
