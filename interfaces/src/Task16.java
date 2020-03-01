import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dmitriy on 04.12.2019.
 */
public class Task16 implements Readable{
    Random rand = new Random(47);

    private int count;
    public Task16 (int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if(count-- == 0)
            return -1;
        String result = Character.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    private char next() {
        return (char) rand.nextInt(128);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new Task16(7));
        while (s.hasNext())
            System.out.print(s.next());
    }
}
