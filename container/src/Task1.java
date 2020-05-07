import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import static util.Countries.capitals;
import static util.Countries.names;
import static util.Print.print;

public class Task1 {
    public static ArrayList<String> listCountries = new ArrayList<String>(names(10));
    public static LinkedList<String> linkedListCountries = new LinkedList<String>(names(15));
    public static void main(String[] args) {
        print(listCountries);
        print(linkedListCountries);
        Collections.sort(listCountries);
        Collections.sort(linkedListCountries);
        print("Sort: " + listCountries);
        print("Sort: " + linkedListCountries);
        Collections.shuffle(listCountries);
        print("1.1 Shuffle: " + listCountries);
        Collections.shuffle(listCountries);
        print("1.2 Shuffle: " + listCountries);
        Collections.shuffle(listCountries);
        print("1.3 Shuffle: " + listCountries);
        Collections.shuffle(linkedListCountries);
        print("2.1 Shuffle: " + linkedListCountries);
        Collections.shuffle(linkedListCountries);
        print("2.2 Shuffle: " + linkedListCountries);
        Collections.shuffle(linkedListCountries);
        print("2.3 Shuffle: " + linkedListCountries);

    }
}
