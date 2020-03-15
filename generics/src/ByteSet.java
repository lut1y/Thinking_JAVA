import java.util.*;

public class ByteSet {
    Byte[] possible = {1,2,3,4,5,6,7,8,9};
    Set<Byte> mySet =  new HashSet<Byte>(Arrays.asList(possible));
//    Set<Byte> mySet2 = new HashSet<Byte>(Arrays.<Byte>asList(1,2,3,4));
    static List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,23,4));

    public static void main(String[] args) {
        System.out.println(list);
    }
}
