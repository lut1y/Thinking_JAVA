abstract class TaskClass<T extends TaskClass<T>> {
    abstract T meth1(T arg);
    T meth2(T arg) {
        System.out.println("meth(T arg)");
        return meth1(arg);
    }
}

class NewClass extends TaskClass<NewClass> {
    NewClass meth1(NewClass arg) {
        System.out.println("meth1(NewClass arg)");
        return arg;
    }
}

public class Task34 {
    public static void main(String[] args) {
        NewClass nc = new NewClass();
        nc.meth1(nc).meth2(nc);
    }

}
