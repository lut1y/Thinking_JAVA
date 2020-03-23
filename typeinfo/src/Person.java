import util.Null;

// Класс с null-объектом
public class Person {
    public final String first;
    public final String last;
    public final String address;
    // и т.д.
    public Person(String first) {
        this.first = first;
        this.last = "";
        this.address = "";
    }

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson extends Person implements Null {

        private NullPerson() {
            super("None", "None", "None");
        }

        public String toString() {
            return "NullPerson";
        }
    }
    public static final Person NULL = new NullPerson();
}
