class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class  Orange extends Fruit {}

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        // Тип времени выполнения - Apple[], а не Fruit[] и не Orange[]
        try {
            // Компилятор позволяет добавлять Fruit:
            fruit[0] = new Fruit(); // ArrayException
        } catch(Exception e) {
            System.out.println(e);
        }
        try {
            // Компиялтор позволяет добавить Orange:
            fruit[0] = new Orange(); // ArrayException
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
