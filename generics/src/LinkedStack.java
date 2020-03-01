// Стек, реализованный на базе списка

public class LinkedStack<T> {
    private static class Node<U> { // Внутренний класс из 2 полей: данных и ссылки
        U item; // данные
        Node<U> next; // ссылка на следующий
        Node() {item=null; next = null;} // Конструктор
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        boolean end() {return item==null && next == null;} // метод для определения конца стека
    }
    private Node<T> top = new Node<T>(); // Сторож  // верхний элемент стека
    public void push(T item) { // метод для укладки значения в стек
        top = new Node<T>(item, top);
    }
    public T pop() { // метод для получения значения из стека
        T result = top.item;
        if(!top.end())
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        for(String s : "Phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while ((s = lss.pop()) != null)
            System.out.println(s);
    }
}
