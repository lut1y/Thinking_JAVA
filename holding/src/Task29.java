import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Dmitriy on 20.12.2019.
 */

class DotherObject extends Object {}

public class Task29 extends DotherObject{
    public static void main(String[] args) {
        Queue<Task29> queue = new PriorityQueue<Task29>();
        queue.offer((Task29) new DotherObject());
        queue.offer((Task29) new DotherObject());
        queue.offer((Task29) new DotherObject());
    }
}
