import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Task11 implements Comparable<Task11> {
    private int i = new Random().nextInt(100);

    public int compareTo(Task11 o) {
        if(o.i > i) return +1;
        else if(o.i == i) return 0;
        else return -1;
    }

    public String toString() {
        return String.valueOf(this.i);
    }

    public static void main(String[] args) {
        Queue<Task11> pq = new PriorityQueue<Task11>();
        pq.add(new Task11());
        pq.add(new Task11());
        pq.add(new Task11());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
