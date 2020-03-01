/**
 * Created by Dmitriy on 23.01.2020.
 */
public class Task10 {
    static boolean primitive(Object o) {
        Object[] fields = o.getClass().getDeclaredFields();
        if(fields.length==0) {
            return true;
        } else {
            return  false;
        }
    }

    public static void main(String[] args) {
        Character[] ch = new Character[]{'a', 'b', 'c'};
        System.out.println("Примитив ли?: [" + primitive(ch) + "]");
        System.out.println("Суперкласс char[] c: " + ch.getClass().getSuperclass());
        System.out.println("Char[] ch instance of: " + (ch instanceof Object));
    }
}
