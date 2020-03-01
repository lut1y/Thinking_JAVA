/**
 * Created by Dmitriy on 24.01.2020.
 */
public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        // Или любой класс, производный от Number
    }
}
