import util.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.PriorityBlockingQueue;

import static util.Print.print;
import static util.Print.printnb;

// Сравнение поведения некоторых очередей
public class QueueBehavior {
    private static int count = 10;
    static <T> void test(Queue<T> queue, Generator<T> gen) {
        printnb(queue.getClass().getSimpleName() + ": ");
        for(int i=0; i<count; i++)
            queue.offer(gen.next());
        while (queue.peek() != null)
            printnb(queue.remove() + " ");
        print();
    }

    static class Gen implements Generator<String> {
        String[] s = ("one two three four five six seven " +
                "eight nine ten").split(" ");
        int i;
        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<String>(), new Gen());
        test(new PriorityQueue<String>(), new Gen());
        test(new ArrayBlockingQueue<String>(count), new Gen());
        test(new ConcurrentLinkedDeque<String>(), new Gen());
        test(new PriorityBlockingQueue<String>(), new Gen());
    }
}
