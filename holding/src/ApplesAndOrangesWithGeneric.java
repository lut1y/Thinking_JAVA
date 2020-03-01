import java.util.ArrayList;

/**
 * Created by 123 on 07.11.2019.
 */
public class ApplesAndOrangesWithGeneric {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for(int i=0; i<3; i++)
            apples.add(new Apple());
        // Ошибка во время компиляции:
//        apples.add(new Orange());
        for(int i=0; i<apples.size(); i++)
            System.out.println(apples.get(i).id());
            // использование синтаксиса foreach
        for(Apple c : apples)
            System.out.println(c.id());
    }
}
