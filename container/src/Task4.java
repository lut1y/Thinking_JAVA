import util.TextFile;
import java.util.AbstractCollection;
import java.util.Iterator;

import static util.Print.print;
import static util.Print.printnb;

public class Task4 extends AbstractCollection {
    private TextFile tf;
    private int index;
    public Task4(TextFile tf) {
        this.tf = tf;
    }
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() {
                return index < size()-1;
            }

            public Object next() {
                return tf.get(index++);
            }
        };
    }

    public int size() {
        return tf.size();
    }

    public static void main(String[] args) {
        Task4 t4 = new Task4(new TextFile("C:\\Users\\Developer\\IdeaProjects\\JAVA\\Thinking_Java\\container\\src\\Task4.java","\\W+"));
        Iterator<String> it = t4.iterator();
        while (it.hasNext())
            printnb(it.next() + " ");
        print();
    }
}
