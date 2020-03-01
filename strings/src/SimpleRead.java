import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Dmitriy on 20.01.2020.
 */
public class SimpleRead {

    public static BufferedReader input = new BufferedReader(
            new StringReader("Sir Robin of Camelot\n22 1.61803"));

    public static void main(String[] args) {
        try {
            System.out.println("What is your name?");
            String name = input.readLine();
            System.out.println(name);
            System.out.println(
                    "How old are you? What you favorite double?");
            System.out.println("(input: <age> <double>)");
            String number = input.readLine();
            System.out.println(number);
            String[] numArray = number.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.format("Hi %s.\n", name);
            System.out.format("In 5 year you will be %d.\n", age + 5);
            System.out.format("My favorite double is %f.", favorite / 2);
        } catch (IOException e) {
            System.err.println("I/O exception");
        }

    }
}
