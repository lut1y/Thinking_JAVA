package music5;

import music4.Note;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * Created by 123 on 29.10.2019.
 */
interface Playable {
    abstract void play(Note n);
}

interface Instrument {
    int VALUE = 5; // по умолчанию static и final
    abstract void adjust();
}

class Wind implements Instrument, Playable {
    public void play(Note n) { System.out.println(this + ".play() " + n); }
    public String toString() {return "Wind";}
    public void adjust() { System.out.println(); };
    public void clearSptitValve() {
        System.out.println(this + ".clearSptitValve()");
    }
}

class Percussion implements Instrument, Playable {
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString() {return "Percussion";}
    public void adjust() {};
}

class Blass extends Wind {
    public String toString() {return "Blass";}
}

public class Music5 {
    static void tune(Playable i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playable[] e) { // обращение как к классу
        for(Playable i : e) {
            if(i instanceof Wind)
                ((Wind) i).clearSptitValve();
            tune(i);
        }
    }

    public static void main(String[] args) {
        Playable[] orchestra = {new Wind(), new Percussion(), new Blass(), new Wind()};
        tuneAll(orchestra);
    }
}
