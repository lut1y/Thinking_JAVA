/**
 * Created by Dmitriy on 23.01.2020.
 */
class A {}
class B extends A {
    int i = 0;
    char ch;
}
class C extends B {}
class D {}

public class Task8 {
    static void printInfo(Object o) {
        // проверяем число полей под объектом o
       Object[] fields = o.getClass().getDeclaredFields();
       if(fields.length == 0)
           System.out.println(o.getClass() + " has no fields");
       if(fields.length > 0) {
           System.out.println("Field(s) of " + o.getClass() + ":");

           for (Object obj : fields)
               System.out.println(" " + obj);
       }
       // проверяем число полей над объектом
       if(o.getClass().getSuperclass() != null) {
           // выводим
           System.out.println(o.getClass() + " is a subclass of " + o.getClass().getSuperclass());
           try {
               // newInstance() - создание класса (обязательно: конструктор по умолчанию!)
               printInfo(o.getClass().getSuperclass().newInstance());
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           } catch (InstantiationException e) {
               e.printStackTrace();
           }
       }
    }

    public static void main(String[] args) {

        printInfo(new B());
    }
}
