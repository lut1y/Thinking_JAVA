import java.util.Arrays;
import java.util.Objects;

public class Task24 implements Comparable<Task24> {
    protected int x;
    Task24(int x) {this.x = x; }
    public int compareTo(Task24 o) {
        return (this.x < o.x ? -1 : (this.x == o.x ? 0 : 1));
    }

    public boolean equals(Object o) {
        return (o.getClass().getSimpleName() == "Task24" && this.x == ((Task24) o).x) ? true : false;
    }

    public static void main(String[] args) {
        Task24[] t24 = { new Task24(1), new Task24(2), new Task24(3) };
        System.out.println(Arrays.toString(t24));
        Arrays.sort(t24);
        int index = Arrays.binarySearch(t24, new Task24(2));
        System.out.println("Index: " + index + ", " + t24[index]);
    }

}
