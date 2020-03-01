class AnyClass {
    public void dispose() {
        System.out.println("AnyClass.dispose()");
    }
}

public class FailingConstructor {
    AnyClass ac;

    public FailingConstructor() {
        ac = new AnyClass();
        try {
            throw new RuntimeException("Искусственная ошибка!");
        } catch (Exception e) {
            System.out.println("Исключение в конструкторе");
        }
        AnyClass ac1 = new AnyClass();
        ac1.dispose();
    }

    public void dispose() {
        System.out.println("FailingConstructor.dispose()");
    }

    public static void main(String[] args) {
        try {
            FailingConstructor fc = new FailingConstructor();
            fc.dispose();
        } catch (RuntimeException re) {
            System.out.println("Поймал косячный конструктор!");
            re.printStackTrace();
            throw re;
        }

    }
}
