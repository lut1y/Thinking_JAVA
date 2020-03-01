/**
 * Created by Dmitriy on 24.01.2020.
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class; // ? - означает "что угодно"
        intClass = double.class;
    }
}
