import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dmitriy on 19.12.2019.
 */

class Command {
    private String s;
    public void operation() {
        System.out.println(this.s);
    }

    public Command(String s) {
        this.s = s;
    }

    public String toString() {
        return this.s;
    }
}

class Third {
    public void printQueue(Queue<Command> queue) {
        for(Command e : queue)
            e.operation();
    }
}

public class Task27 {
    private static void putQueue(Queue<Command> queue) {
        queue.offer(new Command("Картошка"));
        queue.offer(new Command("Морковка"));
        queue.offer(new Command("Горох"));
        queue.offer(new Command("Петрушка"));
        queue.offer(new Command("Свекла"));
        System.out.println(queue);
    }

    private static void printQueue(Queue<Command> queue) {
        for(Command e : queue)
            e.operation();
    }


    public static void main(String[] args) {
        Queue<Command> queueCommands = new LinkedList<Command>();
        putQueue(queueCommands);
        Third th = new Third();
        th.printQueue(queueCommands);

    }
}
