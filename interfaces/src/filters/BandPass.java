package filters;

/**
 * Created by 123 on 29.10.2019.
 */
public class BandPass extends Filter {
    double lowCutoff, highCutoff;
    public BandPass(double lowCut, double highCut) {
        lowCutoff = lowCut;
        highCutoff = highCut;
    }
    public Waveform process (Waveform input) { return input; }
}
