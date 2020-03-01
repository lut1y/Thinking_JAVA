package Switch;

/**
 * Created by Dmitriy on 24.12.2019.
 */
public class Switch {
    public Integer[] x = new Integer[1];
    public boolean read() {return state;}
    private boolean state = false;
    public void on() {state=true;
        System.out.println(this);}
    public void off() {state=false;
        System.out.println(this);}
    public String toString() {return state ? "вкл" : "выкл";}
}


