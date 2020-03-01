import java.time.LocalTime;
import java.util.Date;

import static util.Print.print;
import static util.Print.printnb;

interface  Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        print("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    private static int doCount = 0;
    private static int sECount = 0;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        long timeIn = new Date().getTime();
        print("Time called doSomething() " + doCount + ": " + timeIn + " msecs");
        print("on " + new Date());
        doCount++;
        // ***
        print("SimpleProxy doSomething");
        proxied.doSomething();
        // ***
        print("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }

    @Override
    public void somethingElse(String arg) {
        long timeIn = new Date().getTime();
        print("Time called somethingElse() " + sECount + ": " + timeIn + " msecs");
        print("on " + new Date());
        sECount++;
        // ***
        print("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        // ***
        print("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        print("***");
        consumer(new RealObject());
        print("***");
        consumer(new SimpleProxy(new RealObject()));
        print("***");
        consumer(new SimpleProxy(new RealObject()));
        print("***");
        consumer(new SimpleProxy(new RealObject()));

    }
}
