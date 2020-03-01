import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {
    private int z = 0;
    private String t = "";
    private boolean b = false;

    public Test(int i) {
        z = i;
    }

    public String toString() {
        return "Test:  z=" + z;
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test(0);
        Class aclass = test.getClass();
        System.out.println(aclass);

        aclass = Integer.class;
        System.out.println(aclass);

        int mods = aclass.getModifiers();
        if(Modifier.isPrivate(mods))
            System.out.println("private class");
        if(Modifier.isPublic(mods))
            System.out.println("public class: " + mods);
        if(Modifier.isFinal(mods))
            System.out.println("final class: " + mods);

        Class superclass = aclass.getSuperclass();
        System.out.println("superclass: " + superclass);

        Class[] interfaces = aclass.getInterfaces();
        for(Class i : interfaces)
            System.out.println("interface: " + i.getName());

        Field[] fields = aclass.getDeclaredFields();
        for(Field field : fields) {
            Class type = field.getType();
            System.out.println("* Name: " + field.getName());
            System.out.println("Type: " + field.getType());
        }

        System.out.println("***");
        Field name = aclass.getField("BYTES");
        System.out.println(name);
        System.out.println("***");

        Class bclass = test.getClass();
        Field f = bclass.getDeclaredField("z");
        System.out.println("After: " + test);
        f.set(test, 10);
        System.out.println("Before: " + test);
        System.out.println("***");
        Constructor[] constructors = test.getClass().getDeclaredConstructors();
        for(Constructor constructor : constructors) {
            System.out.println(constructor);
            Class[] paramTypes = constructor.getParameterTypes();
            for(Class paramType : paramTypes)
                System.out.println(paramType.getName() + " ");
        }
        System.out.println("***");
        Class[] paramTypes = new Class[] {int.class};
        Constructor aConstructor = Test.class.getConstructor(paramTypes);
        System.out.println("***");
        Method[] methods = aclass.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println("* Имя: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());
        }

    }
}
