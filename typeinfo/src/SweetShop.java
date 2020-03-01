/**
 * Created by Dmitriy on 21.01.2020.
 */

class Candy {
    static {
        System.out.println("Загрузка класса Candy");
    }
}

class Gum {
    static {
        System.out.println("Загрузка класса Gum");
    }
}

class Cookie {
    static {
        System.out.println("Загрузка класса Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("в методе main");
        new Candy();
        System.out.println("После создания объекта");
        try {
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось найти Gum");
        }
        System.out.println("После вызова метода Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("После создания объекта Cookie");

        System.out.println("*** Task7 ***");
        if(args.length > 1) {
            System.out.println("В методе main");
            for(String arg : args) {
                try {
                    System.out.println("Перед созданием \"" + arg + "\"");
                    Class.forName(arg);
                    System.out.println("После создания \"" + arg + "\"");
                } catch (ClassNotFoundException e) {
                    System.out.println("Не удалось найти " + arg);
                }
            }
        } else {
            System.out.println("Мало аргументов!");
        }
    }
}
