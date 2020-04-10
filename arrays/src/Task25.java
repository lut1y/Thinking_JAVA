import java.util.*;
import static util.Print.print;

public class Task25 {

    class MyList extends ArrayList {
        MyList(List l) { addAll(l); }
        public List getReversed() {
            List result = new ArrayList();
//        for(int i = this.size()-1; i>=0; i--)
//            result.add(this.get(i));
            ListIterator li = this.listIterator(this.size());
            while (li.hasPrevious()) {
                result.add(li.previous());
            }
            return result;
        }
    }

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        print("type: " + aList.getClass().getTypeName());
        print(aList);
        print(aList.get(4));
        aList.add(6);
        aList.addAll(new ArrayList<Integer>(Arrays.asList(7,8)));
        print(aList);
        List<Integer> aSlice = aList.subList(2, 4);
        print(aSlice);
        Task25 t25 = new Task25();
        MyList list2 = t25. new MyList(aList);
        print(list2.getClass().getTypeName());
        print(list2.getReversed());
    }
}
