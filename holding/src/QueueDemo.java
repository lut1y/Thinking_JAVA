import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Dmitriy on 12.11.2019.
 */

// Восходящее преобразование Queue в LinkedList.

public class QueueDemo {
    public static void printQ(Queue queue) {
        while (queue.peek() != null) // peek() - выводит текущий верхний элемент очереди без его извлечения
            System.out.print(queue.remove() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Random rand = new Random(47);
        for(int i=0; i<10; i++)
            queue.offer(rand.nextInt(i+10));
        printQ(queue);
        Queue<Character> qc = new LinkedList<Character>();
        for(char ch : "Brontosaurus".toCharArray())
            qc.offer(ch); // offer() - добавляет в конец очереди
        printQ(qc);
    }
}
