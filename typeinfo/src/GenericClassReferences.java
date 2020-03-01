/**
 * Created by Dmitriy on 24.01.2020.
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class; // это параметризованная ссылка
        genericIntClass = Integer.class; // То же
        intClass = double.class;
//        genericIntClass = double.class;
    }
}
