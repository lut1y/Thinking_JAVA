import java.util.Arrays;

public class Task19 {
    public static int s;
    Task19(int s) { this.s = s;}

    public boolean equals(Object obj) {
        return (obj.getClass().getSimpleName() == "Task19"
                && this.s == ((Task19)obj).s) ? true : false;
    }

    public static void main(String[] args) {
        Task19[] t19 = new Task19[5];
        Task19[] t19_ = new Task19[5];
        Arrays.fill(t19, new Task19(10));
        Arrays.fill(t19_, new Task19(10));
        System.out.println(Arrays.equals(t19, t19_));
        System.out.println("***");
        Task19[][] arT19 = {{new Task19(1), new Task19(2)}, {new Task19(1), new Task19(2)}};
        Task19[][] arT19_ = {{new Task19(1), new Task19(2)}, {new Task19(1), new Task19(2)}};
        System.out.println(Arrays.deepEquals(arT19, arT19_));

        System.out.println(Arrays.toString(t19));

    }
}
