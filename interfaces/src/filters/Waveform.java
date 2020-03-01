package filters;

/**
 * Created by 123 on 29.10.2019.
 */
public class Waveform {
    private static long counter;
    private final long id = counter++;
    public String toString() {return "Waveform " + id;}
}
