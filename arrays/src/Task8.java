import java.util.Arrays;

public class Task8 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Object[] objects = new Object[5];
        objects[0] = new Integer(10);
        objects[1] = new Boolean(Boolean.TRUE);
        objects[2] = new String("Test");
        System.out.println(Arrays.toString(objects));
    }
}
