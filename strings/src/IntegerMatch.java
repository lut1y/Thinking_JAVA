/**
 * Created by Dmitriy on 14.01.2020.
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));

        System.out.println("Простое предложение.".matches("^([A-Z]|[А-Я])+.*[.]$"));
    }
}
