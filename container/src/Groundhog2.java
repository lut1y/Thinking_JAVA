// Класс, используемый в качестве ключа HashMap,
// должен переопределять hashCode() и equals().

public class Groundhog2 extends Groundhog {
    public Groundhog2(int n) { super(n); }
    public int hashCode() { return number; }
    public boolean equals(Object obj) {
        return (obj instanceof Groundhog2) &&
                (number == ((Groundhog2) obj).number);
    }
}
