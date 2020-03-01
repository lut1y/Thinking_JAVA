package music4;

/**
 * Created by 123 on 29.10.2019.
 */

abstract class Instrument {
    private int i;
    public abstract void play(Note n); // обязательно подлежит переопределению
    public String what() {return "Instrument"; }
    public abstract void adjust(); // обязательно подлежит переопределению
}

class Wind extends Instrument {
    public void play(Note n) {
        System.out.println("Wind().play() " + n);
    }
    public String what() {return "Wind";}
    public void adjust() {};
}

class Percussion extends Instrument {
    public void play(Note n) {
        System.out.println("Percussion().play() " + n);
    }
    public String what() {return "Percussion";}
    public void adjust() {};
}

class Brass extends Wind {
    public void play(Note n) {
        System.out.println("Brass().play() " + n);
    }
    public String what() {return "Brass"; }
    public void adjust() {
        System.out.println("Wind");
    }
}

public class Music4 {
    public static void main(String[] args) {
        Instrument[] orchestra = {new Wind(), new Brass(), new Percussion()};

        tuneAll(orchestra);
    }

    static void tuneAll(Instrument[] e) {
        for(Instrument i : e) {
            tune(i);
        }
    }

    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }
}
