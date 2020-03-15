import java.util.ArrayList;
import java.util.List;

// Автоматическая упаковка компенсирует невозможность
// использования примитивов с обощениями.
public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<Integer>();
        for(int i=0; i < 5; i++)
            li.add(i);
        for(int i: li)
            System.out.print(i + " ");
    }
}
