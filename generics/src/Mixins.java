import java.util.Date;

interface TimeStamped { long getStamp(); }

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;
    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }
    public long getStamp() { return timeStamp; }
}

interface SerialNumbered { long getSerialNumber(); }
class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    public void set(String val);
    public String get();
}

class BasicImp implements Basic {
    private String value;
    public void set(String val) { value = val;}
    public String get() { return value; }
}

interface Colored {
    public void setColor(String val);
    public String getColor();
}

class ColoredImp implements Colored {
    private String value;
    public ColoredImp(String value) { this.value = value; }
    public void setColor(String val) { value = val; }
    public String getColor() { return value; }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered, Colored {
    private TimeStamped timeStamped = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private Colored color = new ColoredImp("White");
    public long getStamp() { return timeStamped.getStamp(); }
    public long getSerialNumber() { return serialNumber.getSerialNumber(); }
    public String getColor() { return color.getColor(); }
    public void setColor(String val) { color.setColor(val); }
}

public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        mixin2.setColor("Blue");
        System.out.println(mixin1.get() + " " +
                mixin1.getStamp() + " " + mixin1.getSerialNumber() + " " + mixin1.getColor());
        System.out.println(mixin2.get() + " " +
                mixin2.getStamp() + " " + mixin2.getSerialNumber() + " " + mixin2.getColor());
    }
}