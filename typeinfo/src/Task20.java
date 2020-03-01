import java.beans.ConstructorProperties;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.reflect.*;

import static util.Print.print;
import static util.Print.printnb;

public class Task20 {
    public static void main(String[] args) {
        if(args.length < 1 ) {
            print("Usage: name of class");
            System.exit(0);
        }
        Class<?> c = null;
        try {
            c = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            print("No such class: " + e);
        }
        print("* c: " + c);
        printnb("* c.getAnnotations(): ");
        if(c.getAnnotations().length==0) print("none");
        for(Annotation a : c.getAnnotations())
            print("\t" + a);
        print("* c.getCanonicalName(): " + c.getCanonicalName());
        printnb("* c.getClasses(): ");
        if(c.getClasses().length==0) print("none");
        for(Class cl : c.getClasses())
            print("\t" + cl);
        print("* c.getClassLoader(): " + c.getClassLoader());
        printnb("* c.getConstructors(): ");
        if(c.getConstructors().length == 0) print("none");
        for(Constructor ctor : c.getConstructors())
            print("\t" + ctor);
        printnb("* c.getDeclaredAnnotations(): ");
        if(c.getDeclaredAnnotations().length == 0) print("none");
        print("* c.getDeclaredClasses(): ");
        for(Class cl : c.getDeclaredClasses())
            print("\t" + cl);
        print("* c.getDeclaredConstructor(): ");
        if(c.getDeclaredConstructors().length == 0) print("none");
        for(Constructor ctor : c.getDeclaredConstructors())
            print("\t" + ctor);
        printnb("* c.getDeclaredMethods(): ");
        if(c.getDeclaredMethods().length == 0) print("none");
        for(Method m : c.getDeclaredMethods())
            print("\t" + m);
        print("* c.getDeclaredClasses(): " + c.getDeclaredClasses());
        print("* c.getEnclosingConstructor(): " + c.getEnclosingConstructor());
        print("* c.getEnclosingMethod(): " + c.getEnclosingMethod());
        print("* c.getEnumConstants(): " + c.getEnumConstants());
        print("* c.getDeclaredFields(): ");
        if(c.getDeclaredFields().length == 0) print("none");
        for(Field f : c.getDeclaredFields())
            print("\t" + f);
        printnb("* c.getGenericInterfaces(): ");
        if(c.getGenericInterfaces().length == 0) print("none");
        for(Type t : c.getGenericInterfaces())
            print("\t" + t);
        print("* c.getGenericSuperclass()" + c.getGenericSuperclass());
        printnb("* c.getInterfaces(): ");
        if(c.getInterfaces().length == 0) print("none");
        for(Class i : c.getInterfaces())
            print("\t" + i);
        print("* c.getMethods: ");
        for(Method m : c.getMethods())
            print("\t" + m);
        print("* c.getModifiers(): " + c.getModifiers());
        print("* c.getName(): " + c.getName());
        print("* c.getPackage(): " + c.getPackage());
        print("* c.getProtectionDomain(): " + c.getProtectionDomain());
        printnb("* c.getSigners(): ");
        if(c.getSigners() == null) print(c.getSigners());
        if(c.getSigners() != null) {
            if(c.getSigners() != null) {
                print();
                if(c.getSigners().length==0) print("none");
                if(c.getSigners().length > 0) {
                    for(Object s : c.getSigners())
                        print("\t" + s);
                }
            }
        }
        print("* c.getSimpleName(): " + c.getSimpleName());
        print("* c.getSuperclass(): " + c.getSuperclass());
        print("* c.getTypeParameters(): " + c.getTypeParameters());
        print("* c.isAnnotattion(): " + c.isAnnotation());
        print("* c.isAnnotationPresent(Documented.class): " + c.isAnnotationPresent(Documented.class));
        print("* c.isArray(): " + c.isArray());
        print("* c.isAssignableFrom(Task20.class): " + c.isAssignableFrom(Task20.class));
        print("* c.isAssignableFrom(Object.class): " + c.isAssignableFrom(Object.class));
        print("* c.isEnum(): " + c.isEnum());
        print("* c.isInstance(Object.class): " + c.isInstance(Object.class));
        print("* c.isInterface(): " + c.isInterface());
        print("* c.isLocalClass(): " + c.isLocalClass());
        print("* c.isMemberClass(): " +  c.isMemberClass());
        print("* c.isPrimitive(): " + c.isPrimitive());
        print("* c.isSynthetic(): " + c.isSynthetic());
    }
}
