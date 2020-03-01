/**
 * Created by 123 on 30.10.2019.
 */

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

interface CanClimb {
    void climb();
}

class ActionCharacter {
    public void fight() { System.out.println("CanFight"); }
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly, CanClimb {
    public void swim() {System.out.println("CanSwim");}
    public void fly() {System.out.println("CanFly");}
    public void climb() {System.out.println("CanClimb");};
    public void myMethod() {
        System.out.println("Test method");
    }
}

public class Adventure {
    public static void t(CanFight x) { x.fight(); }
    public static void u(CanSwim x) { x.swim(); }
    public static void v(CanFly x) { x.fly(); }
    public static void w(CanClimb x) { x.climb(); }
    public static void z(ActionCharacter x) { x.fight(); }
    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
        z(h);
    }
}
