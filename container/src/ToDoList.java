import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    public class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(String item, char primary, int secondary) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        public int compareTo(ToDoItem o) {
            if(primary > o.primary)
                return +1;
            if(primary == o.primary)
                if(secondary > o.secondary)
                    return +1;
                else if(secondary == o.secondary)
                    return 0;
            return -1;
        }
        public String toString() {
            return Character.toString(primary) +
                    secondary + ": " + item;
        }
    }
    public void add(String item, char pri, int sec) {
        super.add(new ToDoItem(item, pri, sec));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Free dog", 'A', 2);
        toDoList.add("Free bird", 'B', 7);
        toDoList.add("Water lawn", 'A', 1);
        while (!toDoList.isEmpty())
            System.out.println(toDoList.remove());
    }
}
