package filters;

/**
 * Created by 123 on 29.10.2019.
 */
public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input) { return input; }
}
