import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Dmitriy on 20.12.2019.
 */
public class Task28 {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Queue<Double> queue = new PriorityQueue<Double>();
        for(int i=0; i<10; i++) {
            queue.offer(rand.nextDouble());
        }

        for (int i=0; i < 10; i++) {
            System.out.println((i+1) + " : " + queue.poll());
        }
    }
}
