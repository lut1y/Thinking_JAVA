import packageaccess.HiddenC;

import java.lang.reflect.Method;

public class Task25 {
    public static void main(String[] args) throws Exception {
        interfacea.AA a = HiddenC.makeA();
        a.f();
        Method[] methods = a.getClass().getDeclaredMethods();
        for(Method m : methods) {
            m.setAccessible(true);
            m.invoke(a);
        }
    }
}
