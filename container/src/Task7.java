import util.Countries;

import java.util.*;

import static util.Print.print;
import static util.Print.printnb;

public class Task7 {
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>(Countries.names(8));
        List<String> ll = new LinkedList<String>(Countries.names(8));
        Iterator<String> it = al.iterator();
        printnb("ArrayList: ");
        while(it.hasNext())
            printnb(it.next()  + (it.hasNext() ? ", " : ""));
        print();
        it = ll.iterator();
        printnb("LinkedList: ");
        while(it.hasNext())
            printnb(it.next()  + (it.hasNext() ? ", " : ""));
        print();

        it = ll.iterator();
        ListIterator<String> lit = al.listIterator();
        while(lit.hasNext()) {
            lit.add(it.next());
            lit.next();
        }
        print(al);
        print();

    }
}
