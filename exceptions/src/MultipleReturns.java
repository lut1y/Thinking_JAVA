/**
 * Created by Dmitriy on 24.12.2019.
 */
public class MultipleReturns {
    public static void f(int i) {
        System.out.println("Инициализация, требующая завершения");
        try {
            System.out.println("Точка 1");
            if(i==1) return;
            System.out.println("Точка 2");
            if(i==2) return;
            System.out.println("Точка 3");
            if(i==3) return;
            System.out.println("Конец");
            return;
        } finally {
            System.out.println("Завершение действия");
        }
    }

    public static void main(String[] args) {
        for(int i=1; i <= 4; i++)
            f(i);
    }
}
