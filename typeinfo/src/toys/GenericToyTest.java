package toys;

/**
 * Created by Dmitriy on 24.01.2020.
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class; // создаем ссылку на класс
        // Создаем точный тип:
        FancyToy fancyToy = ftClass.newInstance(); // создаем объект
        Class<? super FancyToy> up = ftClass.getSuperclass(); // создаем ссылку на класс верхний
        // Не компилируется:
//        Class<Toy> up2 = ftClass.getClasses().getSuperclass();
        // Создает только Object:
        Object obj = up.newInstance();
    }
}
